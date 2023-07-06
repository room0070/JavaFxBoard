## MyBatis

MyBatis는 SQL 쿼리를 빌드하기 위한 자체 문법을 제공합니다. 
이러한 문법을 사용하여 데이터베이스에 대한 CRUD(Create, Read, Update, Delete) 작업을 수행할 수 있습니다. 
아래는 MyBatis의 기본 문법에 대한 설명입니다.

### select 문
MyBatis에서 select 문을 작성하는 방법은 다음과 같습니다.
```
<select id="selectById" resultType="com.example.domain.User">
  SELECT * FROM user WHERE id = #{id}
</select>
```
위의 select 문에서는 id라는 이름을 가진 파라미터를 받아와서 user 테이블에서 해당하는 데이터를 조회합니다. resultType 속성에는 조회 결과를 매핑할 클래스의 패키지 경로와 클래스 이름을 지정합니다. 결과를 매핑할 클래스는 User 클래스입니다.

### insert 문
MyBatis에서 insert 문을 작성하는 방법은 다음과 같습니다.
```
<insert id="insert" parameterType="com.example.domain.User">
  INSERT INTO user (id, name, email) VALUES (#{id}, #{name}, #{email})
</insert>
```
위의 insert 문에서는 User 클래스를 파라미터로 받아와서 user 테이블에 데이터를 추가합니다.

### update 문
MyBatis에서 update 문을 작성하는 방법은 다음과 같습니다.
```
<update id="update" parameterType="com.example.domain.User">
  UPDATE user SET name = #{name}, email = #{email} WHERE id = #{id}
</update>
```
위의 update 문에서는 User 클래스를 파라미터로 받아와서 user 테이블에서 해당하는 데이터를 수정합니다.

### delete 문
MyBatis에서 delete 문을 작성하는 방법은 다음과 같습니다.
```
<delete id="deleteById" parameterType="int">
  DELETE FROM user WHERE id = #{id}
</delete>
```
위의 delete 문에서는 id라는 이름을 가진 파라미터를 받아와서 user 테이블에서 해당하는 데이터를 삭제합니다.





## MyBatis 조건문과 반복문
MyBatis에서 조건문과 반복문을 사용하여 SQL 쿼리를 동적으로 작성할 수 있습니다.  

### if 문
if 문을 사용하여 조건에 따라 SQL 쿼리를 동적으로 생성할 수 있습니다. if 문은 test 속성을 사용하여 조건을 지정합니다.  


```
<select id="select" parameterType="com.example.domain.SearchCondition">
  SELECT * FROM user
  <where>
    <if test="id != null">
      AND id = #{id}
    </if>
    <if test="name != null">
      AND name LIKE CONCAT('%', #{name}, '%')
    </if>
    <if test="email != null">
      AND email = #{email}
    </if>
  </where>
</select>
```
위의 select 문에서는 SearchCondition 클래스를 파라미터로 받아와서 user 테이블에서 조건에 따라 데이터를 조회합니다.   
where 태그는 SQL 문장의 WHERE 절을 생성하는 태그이며, 각 조건은 if 태그를 사용하여 작성합니다. 각 if 태그의 test 속성에는 조건식을 지정합니다.  

### choose, when, otherwise 문  
choose, when, otherwise 문을 사용하여 여러 조건 중에서 하나를 선택하여 SQL 쿼리를 동적으로 생성할 수 있습니다.  
```
<select id="select" parameterType="com.example.domain.SearchCondition">
  SELECT * FROM user
  <where>
    <choose>
      <when test="id != null">
        AND id = #{id}
      </when>
      <when test="name != null">
        AND name LIKE CONCAT('%', #{name}, '%')
      </when>
      <when test="email != null">
        AND email = #{email}
      </when>
      <otherwise>
        AND status = 'active'
      </otherwise>
    </choose>
  </where>
</select>

```
위의 select 문에서는 SearchCondition 클래스를 파라미터로 받아와서 user 테이블에서 조건에 따라 데이터를 조회합니다.  
choose 태그는 여러 개의 when 태그와 otherwise 태그를 포함하며, when 태그의 test 속성에는 조건식을 지정합니다.   
조건에 맞는 when 태그가 있으면 해당 SQL 쿼리를 실행하고, 모든 when 태그가 false일 때 otherwise 태그의 SQL 쿼리를 실행합니다.  

### foreach 문
foreach 문을 사용하여 배열이나 리스트를 순회하면서 SQL 쿼리를 동적으로 생성할 수 있습니다.  
foreach 문은 collection, item, index, open, close, separator 속성을 사용합니다.  

```
<update id="update" parameterType="com.example.domain.User">
  UPDATE user SET
  <foreach collection="fields" item="field" separator=",">
    ${field.name} = #{field.value}
  </foreach>
  WHERE id = #{id}
</update>
```
위의 update 문에서는 User 클래스를 파라미터로 받아와서 fields라는 이름의 배열을 순회하면서 user 테이블에서 해당하는 데이터를 수정합니다.  
foreach 태그의 collection 속성에는 순회할 배열이나 리스트를 지정합니다.  
item 속성에는 배열의 각 항목에 대한 이름을 지정하며, separator 속성에는 항목들 사이에 들어갈 구분자를 지정합니다.  

예제
다음은 조건문과 반복문을 함께 사용한 예제입니다.  

```
<select id="select" parameterType="com.example.domain.SearchCondition">
  SELECT * FROM user
  <where>
    <choose>
      <when test="id != null">
        AND id = #{id}
      </when>
      <when test="name != null">
        AND name LIKE CONCAT('%', #{name}, '%')
      </when>
      <when test="email != null">
        AND email = #{email}
      </when>
      <otherwise>
        AND status = 'active'
      </otherwise>
    </choose>
    <if test="orders != null and orders.size > 0">
      ORDER BY
      <foreach collection="orders" item="order" separator=",">
        ${order.field} ${order.direction}
      </foreach>
    </if>
  </where>
</select>
```
위의 select 문에서는 SearchCondition 클래스를 파라미터로 받아와서 user 테이블에서 조건에 따라 데이터를 조회합니다.  
choose 태그는 여러 개의 when 태그와 otherwise 태그를 포함하며, when 태그의 test 속성에는 조건식을 지정합니다.  
foreach 태그는 배열이나 리스트를 순회하면서 SQL 쿼리를 동적으로 생성하는 태그입니다.  
위의 예제에서는 if 태그와 함께 orders라는 이름의 리스트를 순회하면서 SQL 쿼리를 동적으로 생성합니다.  

위의 예제에서는 SearchCondition 클래스에 id, name, email 필드 외에도 orders라는 이름의 리스트를 포함하고 있습니다.   
orders 리스트는 field와 direction 필드를 가진 Order 클래스의 리스트입니다.  
위의 select 문에서는 orders 리스트가 null이 아니고, 항목이 있으면 foreach 태그를 사용하여 field와 direction 값을 순회하면서 SQL 쿼리를 동적으로 생성합니다.  