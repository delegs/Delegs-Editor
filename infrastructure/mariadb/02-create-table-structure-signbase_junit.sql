use signbase_junit;

DROP TABLE IF EXISTS `badgereports`;
CREATE TABLE `badgereports`
(
    `creationdate` datetime NOT NULL,
    `report`       longtext,
    PRIMARY KEY (`creationdate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `databaserevision`;
CREATE TABLE `databaserevision`
(
    `version` int(10) unsigned NOT NULL,
    PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `deletedsigns`;
CREATE TABLE `deletedsigns`
(
    `signupperid` int(100) NOT NULL,
    `revision`    bigint(20) unsigned NOT NULL DEFAULT '0',
    `word`        varchar(100) NOT NULL,
    `language`    varchar(6)   NOT NULL,
    `source`      varchar(100) NOT NULL DEFAULT 'IMPORTED',
    PRIMARY KEY (`signupperid`, `word`, `language`, `source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `username`              varchar(100) NOT NULL,
    `firstname`             varchar(100) DEFAULT NULL,
    `lastname`              varchar(100) DEFAULT NULL,
    `password`              varchar(128) NOT NULL,
    `isadmin`               tinyint(1) NOT NULL DEFAULT '0',
    `email`                 varchar(100) DEFAULT NULL,
    `activated`             tinyint(1) NOT NULL DEFAULT '0',
    `acceptedprivacypolicy` int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (`username`),
    UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `folders`;
CREATE TABLE `folders`
(
    `upperId`             bigint(20) NOT NULL,
    `lowerId`             bigint(20) NOT NULL,
    `parentFolderUpperId` bigint(20) DEFAULT NULL,
    `parentFolderLowerId` bigint(20) DEFAULT NULL,
    `createDate`          datetime              DEFAULT NULL,
    `changeDate`          datetime              DEFAULT NULL,
    `colorLabel`          varchar(45)  NOT NULL DEFAULT 'NONE',
    `owner`               varchar(100)          DEFAULT NULL,
    `title`               varchar(100) NOT NULL,
    PRIMARY KEY (`upperId`, `lowerId`),
    KEY                   `fk_author` (`owner`),
    KEY                   `fk_parentFolder` (`parentFolderUpperId`,`parentFolderLowerId`),
    CONSTRAINT `fk_author` FOREIGN KEY (`owner`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE CASCADE,
    CONSTRAINT `fk_parentFolder` FOREIGN KEY (`parentFolderUpperId`, `parentFolderLowerId`) REFERENCES `folders` (`upperId`, `lowerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `documents`;
CREATE TABLE `documents`
(
    `upperId`             bigint(20) NOT NULL,
    `lowerId`             bigint(20) NOT NULL,
    `parentFolderUpperId` bigint(20) NOT NULL,
    `parentFolderLowerId` bigint(20) NOT NULL,
    `title`               varchar(100) NOT NULL,
    `owner`               varchar(100)          DEFAULT NULL,
    `content`             longtext,
    `createDate`          datetime              DEFAULT NULL,
    `changeDate`          datetime              DEFAULT NULL,
    `colorLabel`          varchar(45)  NOT NULL DEFAULT 'NONE',
    PRIMARY KEY (`upperId`, `lowerId`),
    KEY                   `fk_documents_to_author` (`owner`),
    KEY                   `fk_documents_to_Folder` (`parentFolderUpperId`,`parentFolderLowerId`),
    CONSTRAINT `fk_documents_to_Folder` FOREIGN KEY (`parentFolderUpperId`, `parentFolderLowerId`) REFERENCES `folders` (`upperId`, `lowerId`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_documents_to_author` FOREIGN KEY (`owner`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `localizedappdescriptions`;
CREATE TABLE `localizedappdescriptions`
(
    `language`    varchar(20) NOT NULL,
    `description` longtext    NOT NULL,
    PRIMARY KEY (`language`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification`
(
    `notificationId` int(11) NOT NULL,
    `notification`   text       NOT NULL,
    `language`       varchar(3) NOT NULL,
    `loggedIn`       tinyint(4) NOT NULL,
    PRIMARY KEY (`notificationId`, `language`, `loggedIn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `pdfdocuments`;
CREATE TABLE `pdfdocuments`
(
    `upperId`             bigint(20) DEFAULT NULL,
    `lowerId`             bigint(20) DEFAULT NULL,
    `parentFolderUpperId` bigint(20) DEFAULT NULL,
    `parentFolderLowerId` bigint(20) DEFAULT NULL,
    `title`               varchar(100) DEFAULT NULL,
    `owner`               varchar(100) DEFAULT NULL,
    `colorLabel`          varchar(45)  DEFAULT NULL,
    `createDate`          datetime     DEFAULT NULL,
    `changeDate`          datetime     DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `positionedsymbols`;
CREATE TABLE `positionedsymbols`
(
    `signidupper` int(11) NOT NULL,
    `symbolid`    varchar(100) NOT NULL,
    `x`           int(11) NOT NULL,
    `y`           int(11) NOT NULL,
    `z`           int(11) NOT NULL DEFAULT '0',
    `signword`    varchar(100) NOT NULL,
    `language`    varchar(6)   NOT NULL,
    `source`      varchar(100) NOT NULL DEFAULT 'IMPORTED',
    PRIMARY KEY (`signidupper`, `symbolid`, `x`, `y`, `z`, `signword`, `language`, `source`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `positionedsymbolshistory`;
CREATE TABLE `positionedsymbolshistory`
(
    `signidupper` int(11) NOT NULL,
    `symbolid`    varchar(100) NOT NULL,
    `x`           int(11) NOT NULL,
    `y`           int(11) NOT NULL,
    `z`           int(11) NOT NULL,
    `signword`    varchar(100) NOT NULL,
    `language`    varchar(6)   NOT NULL,
    `source`      varchar(100) NOT NULL,
    `revision`    bigint(20) unsigned NOT NULL,
    PRIMARY KEY (`signidupper`, `symbolid`, `x`, `y`, `z`, `signword`, `language`, `source`, `revision`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `recyclebins`;
CREATE TABLE `recyclebins`
(
    `upperId` bigint(20) NOT NULL,
    `lowerId` bigint(20) NOT NULL,
    PRIMARY KEY (`upperId`, `lowerId`),
    CONSTRAINT `recycle_fk` FOREIGN KEY (`upperId`, `lowerId`) REFERENCES `folders` (`upperId`, `lowerId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms`
(
    `folderUpperId`     bigint(20) NOT NULL,
    `folderLowerId`     bigint(20) NOT NULL,
    `recycleBinUpperId` bigint(20) DEFAULT NULL,
    `recycleBinLowerId` bigint(20) DEFAULT NULL,
    `roomPolicy`        varchar(45) NOT NULL,
    `isHidden`          tinyint(1) NOT NULL DEFAULT '0',
    `description`       varchar(200) DEFAULT NULL,
    PRIMARY KEY (`folderUpperId`, `folderLowerId`),
    KEY                 `fk_rooms_to_recyclebins` (`recycleBinUpperId`,`recycleBinLowerId`),
    CONSTRAINT `fk_rooms_to_folder` FOREIGN KEY (`folderUpperId`, `folderLowerId`) REFERENCES `folders` (`upperId`, `lowerId`) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT `fk_rooms_to_recyclebins` FOREIGN KEY (`recycleBinUpperId`, `recycleBinLowerId`) REFERENCES `recyclebins` (`upperId`, `lowerId`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `roomusers`;
CREATE TABLE `roomusers`
(
    `username`    varchar(100) NOT NULL,
    `roomUpperId` bigint(20) NOT NULL,
    `roomLowerId` bigint(20) NOT NULL,
    `isOwner`     tinyint(1) NOT NULL DEFAULT '0',
    PRIMARY KEY (`username`, `roomUpperId`, `roomLowerId`),
    KEY           `roomusers_room_fk` (`roomUpperId`,`roomLowerId`),
    CONSTRAINT `roomusers_room_fk` FOREIGN KEY (`roomUpperId`, `roomLowerId`) REFERENCES `rooms` (`folderUpperId`, `folderLowerId`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `roomusers_user_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `signrevision`;
CREATE TABLE `signrevision`
(
    `revision` bigint(20) unsigned NOT NULL,
    PRIMARY KEY (`revision`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `signs`;
CREATE TABLE `signs`
(
    `idupper`       int(100) NOT NULL,
    `word`          varchar(100) NOT NULL,
    `owner`         varchar(100) NOT NULL,
    `language`      varchar(6)   NOT NULL,
    `topic`         varchar(100)          DEFAULT NULL,
    `details`       text,
    `width`         int(100) NOT NULL DEFAULT '0',
    `mdtSignPuddle` bigint(20) unsigned NOT NULL DEFAULT '0',
    `revision`      bigint(20) unsigned NOT NULL DEFAULT '1',
    `source`        varchar(100) NOT NULL DEFAULT 'IMPORTED',
    `comment`       text,
    `vidoeUrl`      varchar(200)          DEFAULT NULL,
    PRIMARY KEY (`idupper`, `word`, `language`, `source`),
    KEY             `signsAuthorIndex` (`owner`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `signshistory`;
CREATE TABLE `signshistory`
(
    `idupper`       int(100) NOT NULL,
    `word`          varchar(100) NOT NULL,
    `owner`         varchar(100) NOT NULL,
    `language`      varchar(6)   NOT NULL,
    `topic`         varchar(100) DEFAULT NULL,
    `details`       text,
    `width`         int(100) NOT NULL DEFAULT '0',
    `mdtSignPuddle` bigint(20) unsigned NOT NULL DEFAULT '0',
    `revision`      bigint(20) unsigned NOT NULL,
    `source`        varchar(100) NOT NULL,
    `comment`       text,
    PRIMARY KEY (`idupper`, `word`, `language`, `revision`, `source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `symbols`;
CREATE TABLE `symbols`
(
    `id`        varchar(18) NOT NULL,
    `category`  int(10) unsigned NOT NULL,
    `sgroup`    int(10) unsigned NOT NULL,
    `symbol`    int(10) unsigned NOT NULL,
    `variation` int(10) unsigned NOT NULL,
    `fill`      int(10) unsigned NOT NULL,
    `rotation`  int(10) unsigned NOT NULL,
    `width`     int(100) unsigned NOT NULL DEFAULT '0',
    `height`    int(100) unsigned NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `userbadges`;
CREATE TABLE `userbadges`
(
    `username`      varchar(100) NOT NULL,
    `badgetype`     varchar(45)  NOT NULL,
    `badge`         longtext     NOT NULL,
    `locktimestamp` datetime DEFAULT NULL,
    PRIMARY KEY (`username`, `badgetype`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `usernotification`;
CREATE TABLE `usernotification`
(
    `notificationId` int(11) NOT NULL,
    `username`       varchar(255) NOT NULL,
    PRIMARY KEY (`notificationId`, `username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `userroles`;
CREATE TABLE `userroles`
(
    `username` varchar(100) NOT NULL,
    `role`     varchar(100) NOT NULL,
    PRIMARY KEY (`username`, `role`),
    CONSTRAINT `userroles_user_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `version`;
CREATE TABLE `version`
(
    `version` varchar(100) NOT NULL,
    PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
