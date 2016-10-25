alter table tbl_bill_order add type int;

CREATE TABLE `tbl_bill_balance` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `time` varchar(10) DEFAULT NULL,
  `balance` float(5,2) DEFAULT NULL,
  `type` int(1) DEFAULT '0' COMMENT '0:月份',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `time` (`time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


CREATE DEFINER=`root`@`localhost` PROCEDURE `balance`()
BEGIN
	DECLARE recharge FLOAT DEFAULT 0.0;
  DECLARE trade FLOAT DEFAULT 0.0;
  DECLARE startDate VARCHAR(10);
  DECLARE endDate VARCHAR(10);
  DECLARE total FLOAT;

  set endDate=LAST_DAY(DATE_SUB(NOW(),INTERVAL 1 month));
  set startDate=DATE_SUB(endDate,INTERVAL day(endDate)-1 DAY);

  SELECT SUM(a.total) into recharge FROM `tbl_bill_order` a WHERE a.time >= startDate  AND a.time <= endDate and a.type=0;
  SELECT SUM(a.total) into trade FROM `tbl_bill_order` a WHERE a.time >= startDate  AND a.time <= endDate and a.type=1;

  if recharge is NULL THEN SET recharge=0.0; END if;
  if trade is NULL THEN SET trade=0.0; END IF;

  set total=recharge-trade;
  INSERT INTO tbl_bill_balance(time,balance,update_time)values(startDate,total,NOW()) ON DUPLICATE KEY UPDATE balance=VALUES(balance),update_time=VALUES(update_time);
END;
