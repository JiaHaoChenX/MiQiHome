drop database homeDB;
create database if not exists homeDB default charset utf8;
use homeDB;

-- 删除表
/*
drop table if exists collection;
drop table if exists evaluate;
drop table if exists livePeople;
drop table if exists reserve;
drop table if exists priceReflect;
drop table if exists identityVerification;
drop table if exists identityAction;
drop table if exists continuousDiscount;
drop table if exists homePrice;
drop table if exists picture;
drop table if exists pictureType;
drop table if exists homeRequirementReflect;
drop table if exists homeRequirement;
drop table if exists receptionTime;
drop table if exists homeRules;
drop table if exists homeReflect;
drop table if exists HouseFacilitiesDetails;
drop table if exists homeInformation;
drop table if exists houseDecription;
drop table if exists houseBed;
drop table if exists houseDetails;
drop table if exists houseBedSize;
drop table if exists houseBedType;
drop table if exists houseApartment;
drop table if exists houseScenery;
drop table if exists houseTypeDetails;
drop table if exists houseType;
drop table if exists rentalMode;
drop table if exists houseSite;
drop table if exists homeAllInformation;
drop table if exists userInformation;
drop table if exists regsistAdmin;*/

#管理员注册表
create table regsistAdmin 
(
	raId int primary key auto_increment comment'管理员编号',
    raName nvarchar(16) comment'管理员名字',
	rpicture nvarchar(256) comment '头像',
    raPhone nvarchar(11) comment'手机',
    raEmail nvarchar(32) comment'邮箱',
    raPassword nvarchar(256) comment'管理员密码',
    raRole nvarchar(16) comment'角色(超级管理员，普通管理员)',
    raBirthday TIMESTAMP default now() comment'注册时间',
    raState int default 1 comment'是否存在'
);

#用户个人信息(注册)
create table userInformation
(
    -- 共用
	uiId int primary key auto_increment comment'用户个人信息编号',
    uPhone nvarchar(11) not null comment'电话号码,也叫做账号',
    uPassword nvarchar(256) not null comment'密码',
	upicture nvarchar(256) comment '用户头像',
    uNickName nvarchar(16) comment'用户昵称',
    uEmail nvarchar(32) comment'邮箱',
    uTime TIMESTAMP default now() comment'注册时间',
    -- 房东
    uName nvarchar(16) comment'真实姓名',
    uSex int default 0 comment'性别 0:男 1:女',
    uAge int comment'年龄',
    uDocumentType nvarchar(16) DEFAULT '身份证' comment'证件类型',
    uCardId nvarchar(18) comment'证件号码',
    uNation nvarchar(16) comment'民族',
    uConstellation nvarchar(16) comment'星座',
    uBloodType nvarchar(16) comment'血型',
    uProvince nvarchar(16) comment'省',
    uCity nvarchar(16) comment'市',
    uOccupation nvarchar(16) comment'职业',
    uDesc text comment'备注(对自己的介绍。让房客能更好的认识你)',
    uState int default 1 comment'是否存在0表示注销，1表示存在'
);
select * from userInformation;
update userInformation set uPassword=MD5('123456') where uiId=1;
#update userInformation SET uNickName ='123'  where uiId=123456 ;

-- 房东（添加房源）
#房屋全部信息表（房源表）
create table homeAllInformation
(
	haiId int primary key auto_increment comment'房屋全部信息表编号',
	uiId int comment'关联用户信息表',
	foreign key(uiId) references userInformation(uiId)
);

#查询用户有几套房源
#select * from homeAllInformation h join userInformation u on h.uiId=u.uiId where u.uiId=1;



#房屋位置表
create table houseSite
(
	hsId int primary key auto_increment comment'房屋信息编号',
    hsCountry nvarchar(16) default '中国大陆' comment'房屋所属国家',
    hsProvince nvarchar(16) comment'省',
    hsCity nvarchar(16) comment'市',
    hsArea nvarchar(16) comment'区',
    hsSite nvarchar(256) comment'房屋详细地址',
    hsSupplementary nvarchar(256) comment'补充信息(不可与房屋的详细地址重复)',
	hsHouseNumber nvarchar(16) comment'门牌号(客户预定成功后才会显示)',
    hsLongitude decimal(10,5) comment'经度',
    hsLatitude decimal(10,5) comment'纬度',
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId)
);





# 【房屋详细】
#出租方式表
create table rentalMode
(
	rmId int primary key auto_increment comment'出租方式编号',
	rmName nvarchar(16) comment'出租方式名称'
);
#房屋类型表
create table houseType
(
	htId int primary key auto_increment comment'房屋类型编号',
	htName	nvarchar(12) comment'房屋类型名称'
);
select * from houseType;
#房屋类型详细表(与房屋类型表之间是多对一的关系)
create table houseTypeDetails
(
htdId int primary key auto_increment comment'房屋类型详细编号',
  htdName nvarchar(128) comment'房屋类型详细名称',
  htdDese nvarchar(256) comment '备注',
  htId int comment'关联房屋类型表',
  foreign key(htId) references houseType(htId)
);
select * from houseType;
select * from houseTypeDetails;

#房屋景观表
create table houseScenery
(
hcId int primary key auto_increment comment'房屋景观编号',
  hcName nvarchar(16) comment'房屋景观名称'
);

#房屋户型表
create table houseApartment
(
	haId int primary key auto_increment comment'房屋户型编号',
    haBedroom int default 0 comment'卧室数量',
    haBathroom int default 0 comment'卫生间数量',
    haLounage int default 0 comment'客厅数量',
    haKitchen int default 0 comment'厨房数量',
    haBookStudy int default 0 comment '书房数量',
    haBalcony int default 0 comment '阳台数量'
);

#房屋详细表
create table houseDetails
(
	hdId int primary key auto_increment comment'房屋详细表编号',
    hdArea decimal(10,2) comment'房屋面积',
    hdLiveNumber int comment'居住人数',
    hdHouseNumebr int comment'同类房屋数量(套)(最终会以库存的数量显示)',
    rmId int comment'关联出租方式表',
    foreign key(rmId) references rentalMode(rmId),
    htdId int comment'关联房屋类型表',
    foreign key(htdId) references houseTypeDetails(htdId),
    hcId int comment'关联房屋景观表',
    foreign key(hcId) references houseScenery(hcId),
    haId int comment'关联房屋户型表',
    foreign key(haId) references houseApartment(haId),
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId)
);
            





#床型床类型表
create table houseBedType
(
	hbtId int primary key auto_increment comment'床型床类型编号',
    hbtName nvarchar(16) comment'床型床类型名称'
);

#床型床宽高表
create table houseBedSize
(
	hdsId int primary key auto_increment comment'床型床宽高编号',
    hbsSize varchar(128) comment'长度',
    hbtId int comment'关联床型类型表',
    foreign key(hbtId) references houseBedType(hbtId)
);

#床型表(一个房子有多个床型),关联房屋详细表
create table houseBed
(
	hbId int primary key auto_increment comment'床型编号',
    hdsId int comment'关联床型床类型表',
    foreign key(hdsId) references houseBedSize(hdsId),
    hbtNumber int comment'床数量',
    hdId int comment'关联房屋详细表',
    foreign key(hdId) references HouseDetails(hdId)
);


#房屋描述表
create table houseDecription
(
	hdpId int primary key auto_increment comment'房屋描述编号',
    hdpName nvarchar(128) comment'房屋名称(地标+特色/特点+户型)',
    hdpCharacteristic text comment'房屋特色(软装风格，家居配套，小区环境，物业管理)',
    hdpTraffic text comment'交通位置',
    hdpRound text comment'周边介绍',
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId)
);

#设施服务表
create table HouseFacilities
(
	hfId int primary key auto_increment comment'编号',
	hfName nvarchar(32) comment'类型名称'
);

#房屋设施类型表
create table HouseFacilitiesDetails
(
	hfdId int primary key auto_increment comment'房屋设施详细编号',
    hfdName nvarchar(16) comment'房屋设施详细类型名称',
    hfId int comment'关联设施服务表',
    foreign key(hfId) references HouseFacilities(hfId)
);

#设施服务表对应表
create table HouseFacilitiesReflect
(
	hfrId int primary key auto_increment comment'居家表对应表编号',
    hfdId int comment'房屋设施类型表',
    foreign key(hfdId) references HouseFacilitiesDetails(hfdId),
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId)
);

#入住规则表
create table homeRules
(
	hrId int primary key auto_increment comment'入住规则表编号',
    hrCheckIn varchar(32) comment'房客入住时间',
    hrCheckOut varchar(32) comment'房客退房时间',
    hrProscenium int comment'是否有前台（0：否 1：是）',
    hrSex int default 0 comment'接待性别(0:不限  1:男  2:女)',
    hrSpecialAge int comment'接待特殊年龄段(0:儿童（0-12）  1:老人（65岁以上）)',
    hrHygiene nvarchar(16) comment'多久提供打扫卫生',
    hrSheets nvarchar(16) comment'多久提供被单更换',
    hrTip text comment'入住提示',
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId)
);

#接待房客时间表(关联入住规则表)【一对多】
create table receptionTime
( 
	rtId int primary key auto_increment comment'接待房客时间表编号',
    rtStartTime varchar(16) comment'接待开始时间',
    rtEndTime varchar(16) comment'接待结束时间',
    hrId int comment'关联入住规则表',
    foreign key(hrId) references homeRules(hrId)
);
#对房客的要求表
create table homeRequirement
(
	hreId int primary key auto_increment comment'对房客的要求表编号',
    hreName nvarchar(16) comment'对房客的要求名称'
);

#对房客的要求表对应表(与房客要求表和入住规则表进行关联)【一对多】
create table homeRequirementReflect
(
	hrrId int primary key auto_increment comment'对房客的要求表对应表(编号)',
    hrId int comment'关联入住规则表',
    foreign key(hrId) references homeRules(hrId),
    hreId int comment'关联对房客的要求表',
    foreign key(hreId) references homeRequirement(hreId)
);


#房屋图片表类型
create table pictureType
(
	ptId int primary key auto_increment comment'房屋图片表类型编号',
    ptName nvarchar(16) comment'房屋图片表类型名称',
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId)
);


#房屋图片表(各种类型至少一张，除了其他（如果设为了封面，那么在主页中便显示），图片数量在6-140张，不可上传同名图片)
create table picture
(
	pId int primary key auto_increment comment'房屋图片表编号',
    pUrl nvarchar(256) comment'房屋图片表路径',
    pPagePicture int comment'是否设为封面(0:否 1:是)',
    ptId int comment'关联房屋图片类型表',
    foreign key(ptId) references pictureType(ptId)
);





#房屋价格表
create table homePrice
(
	hpId int primary key auto_increment comment'房屋价格编号',
    hpPrice decimal(10,2) comment'售卖价格',
    cdLeastDay int default 1 comment'最少起订天数',
    cdDeposit decimal(10,2) default 0 comment'收取住房押金',
    cdFullRefund int comment'入住前几天全额退款',
    cdSomeRefund decimal(10,1) comment'除此之外，收取住房费百分之多少(50%)，在这里为0.5',
    cdThreeDiscount decimal(10,1) default 1.0 comment'前三位房客提供折扣优惠(8.0),默认不打折',
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId)
);
select * from homePrice;
#连住折扣表
create table continuousDiscount
(
	cdId int primary key auto_increment comment'连住折扣编号',
    cdDay int comment'连住折扣天数',
    cdDiscount decimal(10,2) comment'折扣设置',
    hpId int comment'关联房屋价格表',
    foreign key(hpId) references homePrice(hpId)
);

#认证方式
create table identityAction
(
	iaId int primary key auto_increment comment'认证方式',
    iaName nvarchar(16) comment'认证名称(身份证、护照、营业执照)'
);

#资质验证
create table identityVerification
(
	ivId int primary key auto_increment comment'身份验证编号',
    ivName nvarchar(32) comment'房东昵称/门店名称 客人可通过名称快速搜索到您的小家',
	ivUrl nvarchar(256) comment'房东头像/门店标志像',
    ivUIDName nvarchar(8) comment'身份证姓名',
    IvUIDNo char(18) comment'身份证编号',
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId)
);

#房屋多种价格对应表(一栋房子有多种不同的价格，在当天前的为无房，如果设置了价格那么价格就为设置的，否则价格为默认价格，即初始价格即可)，（多对一关系）
create table priceReflect
(
	prId int primary key auto_increment comment'房屋多种价格对应表编号',
    prPrice decimal(10,2) comment'设置价格',
    prTime datetime comment'房屋日期',
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId)
);


-- 房客

#预定信息
create table reserve
(
	rvId int primary key auto_increment comment'预定编号',
    rvSerialNumber varchar(32) UNIQUE not null comment '订单编号',
    rvBelowOrder datetime not null comment '下单时间',
    rvStartTime datetime comment'预定开始日期',
    rvEndTime datetime comment'预定结束日期',
    rvTotalDay int comment'预定天数',
    rvHouseNumeb int comment'预定房间套数',
    rvSumMoney decimal(10,2) comment'预定总额',
    rvPhone nvarchar(11) comment'电话号码',
    uiId int comment'关联用户注册表(获得联系人手机号码，当然可以修改，如果修改，则本身的手机号码也会修改)',
    foreign key(uiId) references userInformation(uiId),
    rvInvoice int default 0 comment'是否需要发票 0:不需要 1:需要',
    rvLiveNumber int comment'入住人数',
    rvPayState int default 0 comment'支付状态 0:待付款 1:已完成 2：已取消',
    rvHomeState int default 0 comment'客房预定状态 0：待支付1：待确认2：待入住3：已入住4：已离店5：已取消',
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId)
);
select * from reserve;

#入住人信息（多个）
create table livePeople
(
	lpId int primary key auto_increment comment'入住人编号',
    lpName nvarchar(16) comment'入住人姓名',
    lpPhone nvarchar(11) comment'电话号码',
    lpCardId nvarchar(18) comment'入住人身份证号码',
    rvId int comment'关联预定信息',
    foreign key(rvId) references reserve(rvId)
);
#房屋评价表
create table evaluate
(
	eId int primary key auto_increment comment'评价编号',
    eHygiene int comment'卫生评价星',
    eTraffic int comment'交通位置评价星',
    eEnvironmental int comment'设施环境评价星',
    eService int comment'房东服务评价星',
    eCostPerformance int comment'性价比评价星',
    eEvaluateContent text comment'评价内容',
    eAnswerContent text comment'待回复内容',
    eEvaluateTime TIMESTAMP default now() comment'评价时间',
    eState int comment'评价状态（0：待回复 1：待评价 2:未通过审核）',
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId),
    uiId int comment'关联用户注册表(获得联系人手机号码，当然可以修改，如果修改，则本身的手机号码也会修改)',
    foreign key(uiId) references userInformation(uiId)
);



#房屋收藏表
create table collections
(
	cnId int primary key auto_increment comment'房屋收藏编号',
    haiId int comment'关联房屋全部信息表',
    foreign key(haiId) references homeAllInformation(haiId),
    uiId int comment'关联用户注册表(获得联系人手机号码，当然可以修改，如果修改，则本身的手机号码也会修改)',
    foreign key(uiId) references userInformation(uiId)
);


#drop table geography;
#地区【省、市】
create table  geography
(
	gid int primary key auto_increment comment'编号',
	province nvarchar(16) comment'省',
    region nvarchar(16) comment'市'
);

-- 旅游景点
#drop table scenic_spots;
create table  scenic_spots
(
	ssId nvarchar(16) primary key comment'编号', 
    ssType nvarchar(255) comment'分类', 
    ssProvince nvarchar(255) comment'省份', 
    ssCity nvarchar(255) comment'城市', 
    ssTitle nvarchar(255) comment'标题', 
    ssRank nvarchar(255) comment'级别', 
    ssTemporary nvarchar(255) comment'临时', 
    ssPrint nvarchar(255) comment'图片', 
    ssGrade nvarchar(255) comment'分数', 
    ssTickets nvarchar(255) comment'门票', 
    ssTime nvarchar(255) comment'开放时间', 
    ssSite nvarchar(255) comment'地址', 
    ssIntro nvarchar(5000) comment'简介', 
    ssLongitude nvarchar(255) comment'经度', 
    ssLatitude nvarchar(255) comment'纬度'
);


-- 商圈
CREATE TABLE `circles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `province_name` varchar(50) NOT NULL COMMENT '省',
  `city_name` varchar(50) NOT NULL COMMENT '市',
  `area_name` varchar(50) NOT NULL COMMENT '区',
  `name` varchar(50) NOT NULL COMMENT '商圈',
  `lon` varchar(255) DEFAULT NULL COMMENT '经度',
  `lat` varchar(255) DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8893 DEFAULT CHARSET=utf8 COMMENT='商圈信息表';
-- 高校
create table college
(
	coId int primary key auto_increment comment'高校编号',
    coSchool varchar(100) NOT NULL COMMENT '学校',
    coProvince varchar(50) NOT NULL COMMENT '省',
    coCity varchar(50) NOT NULL COMMENT '市'
);


#数据库备份  zywds
create table databaseBackup
(
	dpId int primary key auto_increment comment'备份id',
    dpPath nvarchar(256) comment'备份路径',
    dpBTime datetime DEFAULT now() comment'备份时间',
    dpFTime datetime comment'还原时间'
);

#数据库备份
insert into databaseBackup(dpPath,dpFTime) values('1','2018-09-09');
insert into databaseBackup(dpPath,dpFTime) values('2','2018-09-09');
insert into databaseBackup(dpPath,dpFTime) values('3','2018-09-09');
insert into databaseBackup(dpPath,dpFTime) values('4','2018-09-09');
insert into databaseBackup(dpPath,dpFTime) values('5','2018-09-09');