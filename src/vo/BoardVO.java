package vo;

public class BoardVO {
	private String boardId;
	private String boardTitle;
	private String boardWriter;
	private String boardDate;
	private String boardContent;
	private String boardType;
	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
    public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	@Override
    public String toString() {
        return "BoardVO [boardId=" + boardId 
        		+ ", boardTitle=" + boardTitle 
        		+ ", boardWriter=" + boardWriter 
        		+ ", boardDate=" + boardDate 
        		+ ", boardType=" + boardType
        		+ "]";
    }

	

}
