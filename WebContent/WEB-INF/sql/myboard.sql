

/*
@@@회원 정보 쿼리
	-테이블 : member_p
*/


--@회원 정보 쿼리
CREATE table member_p (
    memberid VARCHAR2(50) PRIMARY KEY,
    memberpw VARCHAR2(10) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    nickname VARCHAR2(50) UNIQUE,
    regdate DATE NOT NULL
    );
    
    
    
--@게시판 타이틀 쿼리   
CREATE TABLE article_p (
	article_no NUMBER GENERATED AS IDENTITY,
	writer_id VARCHAR2(50) NOT NULL,
	writer_nickname VARCHAR2(50) NOT NULL,
	title VARCHAR2(50) NOT NULL,
	regdate DATE NOT NULL,
	moddate DATE NOT NULL,
	read_cnt NUMBER,
	PRIMARY KEY(article_no)
	);
 
 SELECT * FROM article_p;
 
-- 
--    //게시글 번호
--    //아이디
--    //닉네임
--    //타이틀
--    //작성일
--    //수정일
--    //조회수
 

--@게시판 내용 쿼리
SELECT * FROM article_content_p;

DROP TABLE article_content_p;
CREATE TABLE article_content_p (
                article_no NUMBER PRIMARY KEY,
                content VARCHAR(4000)
                );
                
                
--@rn 만드는 쿼리
SELECT article_no, title, writer_nickname, read_cnt, regdate, row_number() over(order by article_no) rn from article_p;


--@rn을 이용하여 테이블을 다시 정렬하는 쿼리
 SELECT rn, title, writer_nickname, read_cnt, regdate FROM
 (
 SELECT article_no, title, writer_nickname, read_cnt, regdate, row_number() over(order by article_no) rn from article_p
 ) WHERE rn BETWEEN 1 and 2; 