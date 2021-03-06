CREATE TABLE `bus_tend_info` (
  `deal_num` int(11) NOT NULL COMMENT '认购中的份数',
  `succ_num` int(11) NOT NULL COMMENT '认购成功份数',
  `request_no` varchar(32) DEFAULT NULL COMMENT '放款申请流水号',
  `reciver` varchar(32) DEFAULT NULL COMMENT '收款方编号',
  `true_name` varchar(32) DEFAULT NULL COMMENT '收款方',
  `rem_num` int(11) DEFAULT NULL COMMENT '剩余份数',
  `total_num` int(11) NOT NULL COMMENT '总份数',
  `b_t_i_id` varchar(32) NOT NULL COMMENT 'id',
  `b_t_a_id` varchar(32) DEFAULT NULL COMMENT '审请表id',
  `loan_no` varchar(32) NOT NULL COMMENT '标的编号',
  `loan_name` varchar(100) NOT NULL COMMENT '标的名称',
  `b_p_code` varchar(32) NOT NULL COMMENT '产品编号',
  `b_p_name` varchar(100) NOT NULL COMMENT '产品名称',
  `rate` decimal(32,6) NOT NULL COMMENT '产品利率',
  `prod_limit` char(5) DEFAULT NULL,
  `rate_type` char(2) NOT NULL COMMENT '收益方式(01:每月还息，到期返本)',
  `loan_way` char(2) DEFAULT NULL COMMENT '放款方式',
  `is_assi` char(2) DEFAULT NULL COMMENT '债权是否可转让',
  `assi_days` char(8) DEFAULT NULL COMMENT '债权转让起日',
  `org_id` varchar(32) DEFAULT NULL COMMENT '机构号',
  `mana_no` varchar(40) DEFAULT NULL COMMENT '客户经理编号',
  `c_id` varchar(32) NOT NULL COMMENT '借款人编号',
  `c_name` varchar(100) DEFAULT NULL COMMENT '借款人姓名',
  `match_amount` decimal(18,2) DEFAULT NULL COMMENT '待匹配金额',
  `loan_amount` decimal(18,2) NOT NULL COMMENT '借款金额',
  `min_loan_amount` decimal(18,2) NOT NULL COMMENT '最小出借单位',
  `end_date` char(8) DEFAULT NULL COMMENT '投标截至日期',
  `max_copies` int(11) DEFAULT NULL COMMENT '普通会员最大份数',
  `vip_max_copies` int(11) DEFAULT NULL COMMENT '特权会员最大份数',
  `is_credit` varchar(40) DEFAULT NULL COMMENT '是否放款(01：是 02：否)',
  `credit_date` char(8) DEFAULT NULL COMMENT '放款日期',
  `status` char(2) NOT NULL COMMENT '借款标状态(01：等待发标 02 等待认购 03：认购中 04.标满，等待放款 05放款成功(等待授权) 06：放款成功 07：作废 08:解冻失败)',
  `risk_asse` char(2) DEFAULT NULL COMMENT '风险评估(01.高02.中03.低)',
  `bus_desc` text COMMENT '借款方商业概述',
  `rpm_source` text COMMENT '借款方还款来源',
  `loan_purp` text COMMENT '借款方借款用途',
  `rc_meas` text COMMENT '风险控制措施',
  `secu_party` varchar(40) DEFAULT NULL COMMENT '担保方',
  `secured_party` varchar(40) DEFAULT NULL COMMENT '反担保方',
  `acce_path` varchar(100) DEFAULT NULL COMMENT '附件路径',
  `create_date_time` char(14) DEFAULT NULL COMMENT '创建时间',
  `update_time` char(14) DEFAULT NULL COMMENT '更新时间',
  `is_index` varchar(32) DEFAULT NULL COMMENT '是否推荐到首页',
  `is_contr` char(3) DEFAULT NULL COMMENT '是否生成合同(01：未生成  02：生成中  03：己生成)',
  `reserve1` varchar(40) DEFAULT NULL COMMENT '预留字段1',
  `reserve2` varchar(40) DEFAULT NULL COMMENT '预留字段2',
  `reserve3` varchar(40) DEFAULT NULL COMMENT '预留字段3',
  `url` varchar(100) DEFAULT NULL COMMENT '下载合同地址',
  `is_show` varchar(40) DEFAULT NULL COMMENT '是否显示(01：是 02：否)',
  `lose_reason` varchar(255) DEFAULT NULL COMMENT ' 失败原因',
  `stage` varchar(2) DEFAULT NULL COMMENT ' 阶段\n             阶段\n             阶段\n            阶段',
  `loan_status` char(2) DEFAULT NULL COMMENT '放款状态',
  `release_time` char(14) DEFAULT NULL COMMENT '发布时间',
  `total_limit` decimal(18,2) DEFAULT NULL COMMENT '授信额度',
  `tend_type` char(2) DEFAULT NULL,
  `interest_way` char(2) DEFAULT NULL COMMENT '''计息方式(01:标满方款  02:投标当天放款)''',
  `authorize_status` char(2) DEFAULT NULL,
  `invest_end_date` char(8) DEFAULT NULL,
  `curr_num` int(11) DEFAULT NULL,
  `trem_util` char(2) DEFAULT NULL,
  `cash_amount` decimal(18,2) DEFAULT NULL,
  `is_usr_cash` char(8) DEFAULT NULL,
  `contract_code` varchar(32) DEFAULT NULL,
  `cash_num` int(11) DEFAULT NULL,
  `version_no` char(2) DEFAULT NULL,
  `fee_rate` decimal(32,6) DEFAULT NULL,
  `pre_datetime` char(14) DEFAULT NULL,
  `real_datetime` char(14) DEFAULT NULL,
  `full_time` char(14) DEFAULT NULL,
  `is_invest` varchar(40) DEFAULT NULL COMMENT '是否可投(01：是， 02：否，03不显示)',
  `deal_status` char(2) DEFAULT '00',
  `overdue_status` char(2) DEFAULT '01' COMMENT '活期逾期状态',
  `use_special_code` char(2) DEFAULT NULL COMMENT '是否使用专项识别码(01:是02:否)',
  `special_code` varchar(40) DEFAULT NULL COMMENT '专项识别码',
  `special_code_datetime` char(14) DEFAULT NULL COMMENT '专项识别码截止时间',
  `pay_type` varchar(2) DEFAULT '01' COMMENT '支付类型：01支付账号；02银行卡',
  `bd_request_no` varchar(32) DEFAULT NULL COMMENT '标的开户',
  `publish_status` char(2) DEFAULT NULL COMMENT '发布状态',
  PRIMARY KEY (`b_t_i_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标的信息表'














CREATE TABLE `bus_subs` (
  `o_s_id` varchar(32) NOT NULL COMMENT '认购编号',
  `b_t_i_id` varchar(32) NOT NULL COMMENT '标的表id',
  `loan_name` varchar(100) DEFAULT NULL COMMENT '标的名称',
  `inve_c_id` varchar(40) NOT NULL COMMENT '投资人编号',
  `c_i_id` varchar(40) NOT NULL COMMENT '借款人编号',
  `amount` decimal(32,4) NOT NULL COMMENT '认购金额',
  `sub_copies` varchar(40) NOT NULL COMMENT '认购份数',
  `tx_date` char(14) NOT NULL COMMENT '认购时间',
  `resive1` varchar(100) DEFAULT NULL COMMENT '预留',
  `resive2` varchar(100) DEFAULT NULL COMMENT '预留',
  `resive3` varchar(100) DEFAULT NULL COMMENT '预留',
  `create_date_time` char(14) DEFAULT NULL COMMENT '创建时间',
  `update_time` char(14) DEFAULT NULL COMMENT '更新时间',
  `status` varchar(40) DEFAULT NULL COMMENT '状态(01：认购成功 02：认购失败)',
  `curr_num` decimal(11,0) NOT NULL COMMENT '使用和币数',
  `loan_no` varchar(32) DEFAULT NULL COMMENT '标的编号',
  `tend_type` char(2) DEFAULT NULL,
  `is_usr_cash` char(2) DEFAULT NULL,
  `invest_amount` decimal(18,2) DEFAULT NULL,
  `cash` decimal(18,2) DEFAULT NULL,
  `tend_source` char(2) DEFAULT NULL,
  `trans_no` varchar(32) DEFAULT NULL,
  `special_code` varchar(40) DEFAULT NULL COMMENT '专项识别码',
  `escr_channel` varchar(2) DEFAULT NULL,
  `pay_type` varchar(2) DEFAULT NULL COMMENT '支付类型：01支付账号；02银行卡; 03快捷卡,分别对应中金的11/20/30',
  `device_id` varchar(100) DEFAULT NULL COMMENT '设备唯一ID',
  `um_channel` varchar(32) DEFAULT NULL COMMENT 'APP的渠道名称',
  PRIMARY KEY (`o_s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='认购表'






CREATE TABLE `user_info` (
  `u_i_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'id',
  `u_i_name` varchar(100) NOT NULL COMMENT '用户名',
  `u_i_type` char(2) NOT NULL COMMENT '会员类型(01：个人，02：企业)',
  `is_loan` char(2) DEFAULT NULL COMMENT '是否借款人',
  `sex` char(2) DEFAULT NULL COMMENT '客户性别',
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `pass_word` varchar(40) NOT NULL COMMENT '密码',
  `imgrul` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `is_email` char(2) DEFAULT NULL COMMENT '邮件是否验证通过(01：是 02：否)',
  `status` char(2) NOT NULL COMMENT '状态(01：正常 02：锁定 03：禁用)',
  `vip_type` char(3) DEFAULT NULL COMMENT '会员类型(1：普通会员 2：vip会员)',
  `vip_lev` char(2) DEFAULT NULL COMMENT '会员等级',
  `ty_id` varchar(32) DEFAULT NULL COMMENT '推荐人id',
  `tg_no` varchar(32) DEFAULT NULL COMMENT '推广编号',
  `channel` varchar(2) NOT NULL COMMENT '注册渠道(01：pc  02:手机)',
  `real_name` varchar(40) DEFAULT NULL COMMENT '真实姓名',
  `idcard_type` varchar(2) DEFAULT NULL COMMENT '证件类型',
  `idcard_no` varchar(255) DEFAULT NULL,
  `escr_no` varchar(32) DEFAULT NULL COMMENT '托管会员编号',
  `is_escr` char(2) DEFAULT NULL COMMENT '资金托管开户(01:开户成功  02：开户失败 03：结果未知)',
  `escr_channel` varchar(2) DEFAULT NULL COMMENT '资金托管渠道',
  `create_date_time` char(14) DEFAULT NULL COMMENT '创建时间',
  `update_time` char(14) DEFAULT NULL COMMENT '更新时间',
  `idcard_no_v` varchar(40) DEFAULT NULL COMMENT '身份证*',
  `phone_v` varchar(40) DEFAULT NULL COMMENT '手机*',
  `is_submit` char(2) DEFAULT NULL COMMENT '是否可以提现(01 可以  02：不可以)',
  `ente_type` char(2) DEFAULT NULL COMMENT '（01个人：02企业借款人：03：担保公司）',
  `active_status` char(2) DEFAULT '',
  `return_visit_status` char(2) DEFAULT '03' COMMENT '用户回访状态（01:有效 02: 无效 03:未知 04:信息不符）',
  `return_visit_operator` varchar(32) DEFAULT NULL COMMENT '修改回访状态的用户id',
  `tg_src` varchar(32) DEFAULT NULL,
  `ges_code` varchar(40) DEFAULT NULL COMMENT '手势密码',
  `is_new_user` char(2) DEFAULT NULL COMMENT '01:新用户；02：老用户；03投资中，未知',
  `resive1` varchar(255) DEFAULT NULL,
  `resive2` varchar(255) DEFAULT NULL,
  `resive3` varchar(255) DEFAULT NULL,
  `is_autoinvest` char(2) DEFAULT '02' COMMENT '是否开通自动投标授权：01是，02否',
  `is_xman` char(2) DEFAULT '02' COMMENT '是否X-MAN：01是，02否 03曾经是xman  04 设置为xman中间状态',
  `move_step` char(2) NOT NULL DEFAULT '0' COMMENT '资金转移处理步骤记录 0：未转移 1:同意转移  2:自动投标设置完成  3.中金账户开通',
  `device_id` varchar(100) DEFAULT NULL COMMENT '设备唯一ID',
  `um_channel` varchar(32) DEFAULT NULL COMMENT 'APP的渠道名称',
  `ip` varchar(32) DEFAULT NULL COMMENT '用户注册提交时的公网IP',
  `ty_cpsid` varchar(32) DEFAULT NULL COMMENT '推广系统推广人ID',
  `spread_channel` varchar(32) DEFAULT NULL COMMENT '推广渠道',
  PRIMARY KEY (`u_i_id`),
  UNIQUE KEY `user_info_phone` (`phone`) USING BTREE,
  KEY `USER_INFO_CREATE_DATE_TIME` (`create_date_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户信息'