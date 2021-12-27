CREATE SCHEMA IF NOT EXISTS signbase DEFAULT COLLATE utf8_general_ci;
CREATE SCHEMA IF NOT EXISTS signbase_junit DEFAULT COLLATE utf8_general_ci;

CREATE USER 'app_signbase_dev'@'%' IDENTIFIED BY '+signbase#';
GRANT ALL PRIVILEGES ON signbase.* TO 'app_signbase_dev'@'%';
GRANT ALL PRIVILEGES ON signbase_junit.* TO 'app_signbase_dev'@'%';

CREATE USER 'signbase_test'@'%' IDENTIFIED BY '+signbase#';
GRANT ALL PRIVILEGES ON signbase.* TO 'signbase_test'@'%';
GRANT ALL PRIVILEGES ON signbase_junit.* TO 'signbase_test'@'%';

SET GLOBAL max_connections = 500;