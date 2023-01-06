SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS PAPAGO_TRANSLATE;




/* Create Tables */

CREATE TABLE PAPAGO_TRANSLATE
(
	PT_NUM int NOT NULL AUTO_INCREMENT,
	PT_SOURCE char(5) NOT NULL,
	PT_TEXT text NOT NULL,
	PT_TARGET char(5) NOT NULL,
	PT_RESULT text NOT NULL,
	PRIMARY KEY (PT_NUM)
);



