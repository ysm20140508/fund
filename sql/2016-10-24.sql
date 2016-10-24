CREATE TABLE `tbl_bill_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `good_id` int(11) DEFAULT NULL,
  `good_name` varchar(20) DEFAULT NULL,
  `good_type` varchar(20) DEFAULT NULL,
  `total` float(20,2) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `tbl_bill_good` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` float(20,2) DEFAULT NULL,
  `from_area` varchar(20) DEFAULT NULL,
  `to_area` varchar(20) DEFAULT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

