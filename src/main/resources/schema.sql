DROP DATABASE IF EXISTS demodb;
CREATE DATABASE demodb;
USE demodb;

-- ----------------------------
--  Table structure for tb_user
-- ----------------------------
DROP TABLE
  IF EXISTS tb_user;

CREATE TABLE tb_user
(
  user_id      BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL
    COMMENT '用户ID',
  account      VARCHAR(20)                           NOT NULL
    COMMENT '账号',
  password     VARCHAR(64)                           NOT NULL
    COMMENT '密码',
  salt         VARCHAR(64)                           NOT NULL
    COMMENT '密码盐',
  is_deleted   TINYINT                               NOT NULL DEFAULT 0
    COMMENT '逻辑删除',
  created_time TIMESTAMP                             NOT NULL DEFAULT CURRENT_TIMESTAMP
    COMMENT '创建时间',
  updated_time TIMESTAMP                             NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    COMMENT '更新时间'
)
  COMMENT '用户表';
CREATE UNIQUE INDEX tb_account_UNIQUE
  ON tb_user (account);