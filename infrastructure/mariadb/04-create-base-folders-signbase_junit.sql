use signbase_junit;

INSERT INTO folders
(upperId, lowerId, parentFolderUpperId, parentFolderLowerId, createDate, changeDate, colorLabel, owner, title)
VALUES (0, 0, NULL, NULL, '2011-11-15 11:00:00.000', '2011-11-15 11:00:00.000', 'NONE', 'delegs', 'Home');
INSERT INTO folders
(upperId, lowerId, parentFolderUpperId, parentFolderLowerId, createDate, changeDate, colorLabel, owner, title)
VALUES (0, 1, 0, 0, '2015-03-05 11:00:00.000', '2015-03-05 11:00:00.000', 'NONE', 'system', 'System');
INSERT INTO folders
(upperId, lowerId, parentFolderUpperId, parentFolderLowerId, createDate, changeDate, colorLabel, owner, title)
VALUES (0, 2, 0, 0, '2012-02-02 11:00:00.000', '2012-02-02 11:00:00.000', 'NONE', 'delegs', 'Playground');
INSERT INTO folders
(upperId, lowerId, parentFolderUpperId, parentFolderLowerId, createDate, changeDate, colorLabel, owner, title)
VALUES (0, 3, 0, 1, '2015-03-05 11:00:00.000', '2015-03-05 11:00:00.000', 'NONE', 'system', 'copycache');
INSERT INTO folders
(upperId, lowerId, parentFolderUpperId, parentFolderLowerId, createDate, changeDate, colorLabel, owner, title)
VALUES (0, 4, 0, 0, '2017-12-13 15:37:00.000', '2017-12-13 15:37:00.000', 'NONE', 'delegs', 'Showroom');
INSERT INTO folders
(upperId, lowerId, parentFolderUpperId, parentFolderLowerId, createDate, changeDate, colorLabel, owner, title)
VALUES (0, 5, 0, 4, '2017-12-20 09:33:00.000', '2017-12-20 09:33:00.000', 'YELLOW', 'delegs', 'Quiz');
INSERT INTO folders
(upperId, lowerId, parentFolderUpperId, parentFolderLowerId, createDate, changeDate, colorLabel, owner, title)
VALUES(1331043628619, 1, 0, 2, '2012-03-06 15:22:59.000', '2012-03-06 15:22:59.000', 'NONE', 'delegs', 'Papierkorb');

INSERT INTO rooms
(folderUpperId, folderLowerId, recycleBinUpperId, recycleBinLowerId, roomPolicy, isHidden, description)
VALUES(0, 0, NULL, NULL, 'individualContent', 0, NULL);
INSERT INTO rooms
(folderUpperId, folderLowerId, recycleBinUpperId, recycleBinLowerId, roomPolicy, isHidden, description)
VALUES(0, 1, NULL, NULL, 'individualContent', 1, NULL);
INSERT INTO rooms
(folderUpperId, folderLowerId, recycleBinUpperId, recycleBinLowerId, roomPolicy, isHidden, description)
VALUES(0, 2, NULL, NULL, 'sharedContent', 0, NULL);
INSERT INTO rooms
(folderUpperId, folderLowerId, recycleBinUpperId, recycleBinLowerId, roomPolicy, isHidden, description)
VALUES(0, 4, NULL, NULL, 'showroom', 0, NULL);

INSERT INTO recyclebins
(upperId, lowerId)
VALUES(1331043628619, 1);

UPDATE rooms
set recycleBinUpperId = 1331043628619, recycleBinLowerId = 1
where folderUpperId = 0 and folderLowerId = 2;