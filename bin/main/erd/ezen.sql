SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS BOARD_INFO;
DROP TABLE IF EXISTS USER_INFO;




/* Create Tables */

CREATE TABLE BOARD_INFO
(
	BI_NUM int NOT NULL AUTO_INCREMENT,
	BI_TITLE varchar(300) NOT NULL,
	BI_CONTENT text NOT NULL,
	BI_CREDAT char(8) NOT NULL,
	BI_CRETIM char(6) NOT NULL,
	BI_LMODAT char(8) NOT NULL,
	BI_LMOTIM char(6) NOT NULL,
	BI_ACTIVE char NOT NULL,
	BI_CNT int NOT NULL,
	UI_NUM int unsigned NOT NULL,
	PRIMARY KEY (BI_NUM)
);


CREATE TABLE USER_INFO
(
	UI_NUM int unsigned NOT NULL AUTO_INCREMENT,
	UI_ID varchar(30) NOT NULL,
	UI_NAME varchar(50) NOT NULL,
	UI_PWD varchar(50) NOT NULL,
	UI_EMAIL varchar(50) NOT NULL,
	UI_ZIP char(5) NOT NULL,
	UI_ADDR1 varchar(200) NOT NULL,
	UI_ADDR2 varchar(100),
	UI_PROFILE varchar(4000),
	UI_PROFILE_IMG_PATH varchar(100),
	PRIMARY KEY (UI_NUM),
	UNIQUE (UI_ID)
);



/* Create Foreign Keys */

ALTER TABLE BOARD_INFO
	ADD FOREIGN KEY (UI_NUM)
	REFERENCES USER_INFO (UI_NUM)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



