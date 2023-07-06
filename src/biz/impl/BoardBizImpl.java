package biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.BoardDao;
import dao.impl.BoardDaoImpl;
import mybatis.MySession;
import vo.BoardVO;
import biz.BoardBiz;

/**
 * @author 김태호
 * @version 1.0
 * 
 * <p>
 * 파일명 : BoardBizImpl.java <br/>
 * 설명 : 게시판 Biz 구현클래스 <br/>
 * 
 * 수정이력<br/>
 * --------------------------------------------<br/>
 * 수정일자     |수정인|수정내용<br/>
 * --------------------------------------------<br/>
 * 2023.01.04 김태호 최초생성<br/>
 * --------------------------------------------<br/>
 * </p>
 */

public class BoardBizImpl implements BoardBiz{
	
	private BoardDao dao = BoardDaoImpl.getInstance();
	
	
	@Override
	public List<BoardVO> selectBoardList(String boardTitle, String boardWriter, String boardType) {
		System.out.println("selectBoardList");
		SqlSession mapper = MySession.getSession();
		return dao.selectBoardList(mapper, boardTitle, boardWriter, boardType);
	}

	@Override
	public BoardVO selectBoard(String boardId) {
		System.out.println("selectBoard");
		SqlSession mapper = MySession.getSession();
		return dao.selectBoard(mapper, boardId);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard");
		SqlSession mapper = MySession.getSession();
		dao.insertBoard(mapper, vo);
		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard");
		SqlSession mapper = MySession.getSession();
		dao.updateBoard(mapper, vo);
	}

	@Override
	public void deleteBoard(String boardId) {
		System.out.println("deleteBoard");
		SqlSession mapper = MySession.getSession();
		dao.deleteBoard(mapper, boardId);
	}
	
}
