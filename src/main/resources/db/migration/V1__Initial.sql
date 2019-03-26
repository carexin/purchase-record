CREATE TABLE `supplier` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `contacts` varchar(60) NOT NULL DEFAULT '' COMMENT '联系人',
    `phone` varchar(13) DEFAULT '' COMMENT '手机号码',
    `telephone` varchar(13) DEFAULT '' COMMENT '电话号码',
    `address` varchar(255) DEFAULT '' COMMENT '地址',
    `remarks` varchar(255) DEFAULT '' COMMENT '备注',
    `is_active` tinyint(4) DEFAULT '1' COMMENT '进货商状态(1正常，0未启动)',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `contacts_unique` (`contacts`) USING BTREE
) COMMENT='供货商';

create table `order`(
   `order_id` varchar(32) not null ,
   `freight` decimal(8,2) not null comment '运费(元)',
   `total_price` decimal(8,2) not null comment '总价(元)',
   `order_status` tinyint(3) not null default '0' comment '订单状态, 0有效, 1无效',
   `supplier_id` int(11) not null comment 'supplier id',
   `create_time` timestamp not null default current_timestamp comment '创建时间',
   `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
   `remarks` varchar(255) DEFAULT '' COMMENT '备注',
   primary key (`order_id`),
   key `idx_supplier_id` (`supplier_id`)
) COMMENT='订单';

create table `order_detail`(
  `detail_id` varchar(32) not null ,
  `goods_name` varchar(32) not null comment '商品名称',
  `amount` decimal(8,2) not null comment '总量(数量)',
  `unit_price` decimal(8,2) not null comment '单价(元)',
  `detail_price` decimal(8,2) not null comment '价格(元)',
  `detail_status` tinyint(3) not null default '0' comment '订单状态, 0有效, 1无效',
  `order_id` varchar(32) not null comment 'order id',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  `remarks` varchar(255) DEFAULT '' COMMENT '备注',
  primary key (`detail_id`),
  key `idx_order_id` (`order_id`)
) comment = '订单明细';