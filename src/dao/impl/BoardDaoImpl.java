package dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.BoardDao;
import vo.BoardVO;

/**
 * @author 김태호
 * @version 1.0
 * 
 *          <p>
 *          파일명 : BoardDaoImpl.java <br/>
 *          설명 : 게시판 DAO 구현클래스 <br/>
 * 
 *          수정이력<br/>
 *          --------------------------------------------<br/>
 *          수정일자 |수정인|수정내용<br/>
 *          --------------------------------------------<br/>
 *          2017.01.24 김태호 최초생성<br/>
 *          --------------------------------------------<br/>
 *          </p>
 */

public class BoardDaoImpl implements BoardDao {

	// 싱글톤 패턴을 사용하기 위한 자신 클래스의 인스턴스
	private static BoardDaoImpl boardDaoImpl = new BoardDaoImpl();
	

	private BoardDaoImpl() {
		
	}

	public static BoardDaoImpl getInstance() {
		return boardDaoImpl;
	}

	@Override
	public List<BoardVO> selectBoardList(SqlSession mapper, String boardTitle, String boardWriter, String boardType) {
		System.out.println("dao selectBoardList");
		List<BoardVO> resultList = null;
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardTitle(boardTitle);
		boardVO.setBoardWriter(boardWriter);
		boardVO.setBoardType(boardType);
		
		System.out.println(boardVO);
		
		try {
			resultList = mapper.selectList("test.selectTest", boardVO);
			System.out.println(resultList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public BoardVO selectBoard(SqlSession mapper, String boardId) {
		BoardVO vo = null;
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(boardId);
		System.out.println("boardId : " + boardId);
		try {
			vo = (BoardVO) mapper.selectOne("test.selectTest", boardVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;

	}

	@Override
	public void insertBoard(SqlSession mapper, BoardVO vo) {
		try {
			mapper.insert("test.insertTest", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateBoard(SqlSession mapper, BoardVO vo) {

		try {
			mapper.update("test.updateTest", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBoard(SqlSession mapper, String boardId) {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(boardId);

		try {
			mapper.delete("test.deleteTest", boardVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
