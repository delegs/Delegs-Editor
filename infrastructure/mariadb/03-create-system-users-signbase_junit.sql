use signbase_junit;

INSERT INTO `user`
(username, firstname, lastname, password, isadmin, email, activated, acceptedprivacypolicy)
VALUES ('delegs', 'delegs', '', '86461f57a55af1cbf74051555a84981b378a4f9811c21874d787c9643b385019', 1, NULL, 1, 1);
INSERT INTO `user`
(username, firstname, lastname, password, isadmin, email, activated, acceptedprivacypolicy)
VALUES ('system', 'system', 'system', 'dd6b34345dd40c94a0e1331b013391fedb4efda7fc30f6ca207b16a980ff8000', 1, NULL, 1, 1);
INSERT INTO `user`
(username, firstname, lastname, password, isadmin, email, activated, acceptedprivacypolicy)
VALUES('deleted', 'deleted', 'deleted', '', 0, NULL, 1, 0);
INSERT INTO `user`
(username, firstname, lastname, password, isadmin, email, activated, acceptedprivacypolicy)
VALUES('unknown', 'unknown', 'unknown', '', 0, NULL, 1, 0);
INSERT INTO `user`
(username, firstname, lastname, password, isadmin, email, activated, acceptedprivacypolicy)
VALUES('imported', '', '', '', 0, NULL, 1, 0);
INSERT INTO `user`
(username, firstname, lastname, password, isadmin, email, activated, acceptedprivacypolicy)
VALUES('SignWritingEditor', '', '', '', 0, NULL, 1, 0);

INSERT INTO userroles
(username, `role`)
VALUES('delegs', 'AUTHOR');
INSERT INTO userroles
(username, `role`)
VALUES('delegs', 'USER');
INSERT INTO userroles
(username, `role`)
VALUES('deleted', 'USER');
INSERT INTO userroles
(username, `role`)
VALUES('imported', 'USER');
INSERT INTO userroles
(username, `role`)
VALUES('SignWritingEditor', 'USER');
INSERT INTO userroles
(username, `role`)
VALUES('system', 'USER');
INSERT INTO userroles
(username, `role`)
VALUES('unknown', 'USER');
