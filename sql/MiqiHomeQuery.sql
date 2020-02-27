#出租方式表
insert into rentalMode(rmName) values('整套房屋'),('独立房间');
#房屋类型表
insert into houseType(htName) values('公寓'),('客栈'),('别墅'),('其他/特色');
insert into houseTypeDetails(htId,htdName,htdDese) VALUES
(1,'普通公寓','个人房东经营的小区、公寓楼内房屋'),
(1,'酒店式公寓','提供酒店式服务的公寓'),
(2,'客栈','外形具有明显当地或民俗特色'),
(3,'独栋别墅','独门独院，无共用墙'),
(3,'别墅单间','别墅中的单个房间，有独卫'),
(3,'独栋别墅','独门独院，无共用墙'),
(3,'别墅单间','别墅中的单个房间，有独卫'),
(3,'联排别墅','独门独院，有共用墙'),
(3,'叠拼别墅','多层复式，上下叠加在一起'),
(4,'农家乐','农村文化民宅'),
(4,'老洋房','带有国外风格、历史元素，以上海为典型'),
(4,'四合院','中间小院，四面房屋，以北京为典型'),
(4,'渔家乐','水边带有渔村文化民宅'),
(4,'木屋','木材为主要材料建造'),
(4,'韩屋',''),
(4,'房车营地','由车改造，住在车上及配套休息场所'),
(4,'蒙古包','圆形造型的蒙古族特有民居'),
(4,'吊脚楼','半悬空而建，少数民族传统民居'),
(4,'帐篷营地','以帐篷为造型及配套休息场所'),
(4,'土楼','客家地区且以生土筑墙'),
(4,'集装箱','外形为集装箱形状'),
(4,'石屋',''),
(4,'树屋','建在树干或树枝上'),
(4,'游艇','住宿、娱乐均在游艇'),
(4,'窑洞','黄土高原上依山凿洞而建'),
(4,'竹屋','竹子为主要材料建造'),
(4,'碉楼','碉堡形状'),
(4,'Loft复式','上下双层、复式结构'),
(4,'船屋','由船改造，住在船上');


#房屋景观表
insert into houseScenery(hcName) values('海景'),('湖景'),('江景'),('山景');

#床型床类型表
insert into houseBedType(hbtName) values('大床'),('圆床'),('双层床'),('双人沙发床')
,('单人床'),('单人沙发床'),('儿童床'),('儿童双层床'),('榻榻米'),('炕'),('地上床垫');

#床型床宽高表
insert into houseBedSize(hbtId,hbsSize) VALUES
(1,'2×1.8米')
,(1,'2×1.5米')
,(1,'1.8×1.5米')
,(1,'2×2米')
,(1,'2×1.6米')
,(1,'2.2×2.2米')
;

insert into houseBedSize(hbtId,hbsSize) VALUES
(2,'直径2米')
,(2,'直径2.2米')
;
insert into houseBedSize(hbtId,hbsSize) VALUES
(3,'0.9×1.9米上床,1.2×1.9米下床')
,(3,'1.2×1.9米上床,1.5×1.9米下床')
,(3,'1.2×1.9米上床,1.5×1.9米下床')
,(3,'0.9×1.9米')
,(3,'1×1.9米')
,(3,'1.2×1.9米')
;
insert into houseBedSize(hbtId,hbsSize) VALUES
(4,'2×1.5米')
;

insert into houseBedSize(hbtId,hbsSize) VALUES
(5,'2×1米')
,(5,'2×1.2米')
,(5,'1.9×1.2米')
,(5,'2×0.8米')
,(5,'2×1.1米')
,(5,'2×1.3米')
;

insert into houseBedSize(hbtId,hbsSize) VALUES
(6,'2×1.2米'),(6,'1.5×1米'),(6,'2×1.2米'),(7,'1.8×1.2(1)米'),(7,'2×1.2米');

insert into houseBedSize(hbtId,hbsSize) VALUES
(8,'2×1.2米'),(8,'2×1.5米'),(8,'2×1.8米'),(8,'大通铺');
insert into houseBedSize(hbtId,hbsSize) VALUES
(9,'2×1.5米'),(9,'2×1.8米'),(9,'2.2×2.2米'),(9,'大通铺');
insert into houseBedSize(hbtId,hbsSize) VALUES
(10,'2.2×1.2米'),(10,'2×1.5米'),(10,'2×1.8米');

#设施服务表
insert into HouseFacilities(hfName) values('居家'),('卫浴'),('餐厨'),('娱乐')
,('安全'),('建筑'),('周边(500内)'),('其他');

#房屋设施类型表
insert into HouseFacilitiesDetails(hfId,hfdName) values 
(1,'无线网络'),(1,'有线网络'),(1,'电视'),(1,'电视(55寸含以上)'),(1,' 拖鞋'),
(1,'电热水壶'),(1,'全部客厅卧室有空调'),(1,'部分客厅卧室有空调'),(1,'电吹风'),(1,' 晾衣架'),
(1,'冰箱'),(1,' 对开门冰箱'),(1,'洗衣机'),(1,'烘干机/干衣机'),(1,'打扫工具'),
(1,'洗衣粉/液'),(1,'暖气'),(1,'电熨斗/挂烫机'),(1,'加湿器'),(1,'空气净化器'),
(1,'新风系统'),(1,'地毯'),(1,'挂墙装饰画/字画'),(1,'真皮/实木沙发'),(1,'休闲椅'),
(1,'茶几'),(1,'净水机/滤水系统'),(1,'中央空调');

insert into HouseFacilitiesDetails(hfId,hfdName) values 
(2,'独立卫浴'),(2,'全天热水'),(2,'分时段热水'),(2,'洗发水/沐浴露'),(2,'牙具'),
(2,'毛巾'),(2,'卫生纸'),(2,'浴巾'),(2,'香皂/洗手液'),(2,' 浴缸'),
(2,'智能马桶盖');

insert into HouseFacilitiesDetails(hfId,hfdName) values 
(3,'烹饪锅具'),(3,'餐具'),(3,'电饭煲'),(3,'刀具菜板'),(3,' 燃气灶'),
(3,'洗涤用具'),(3,'电磁炉'),(3,'调料'),(3,'微波炉'),(3,' 烧烤器具'),
(3,'整体厨柜');

insert into HouseFacilitiesDetails(hfId,hfdName) values 
(4,'麻将机'),(4,'拉OK/家庭影院'),(4,'投影设备'),(4,'游戏机'),(4,'桌面足球'),
(4,'音响/蓝牙音箱');

insert into HouseFacilitiesDetails(hfId,hfdName) values 
(5,'保安'),(5,'门禁系统'),(5,'灭火器'),(5,'智能门锁'),(5,'火灾警报器'),
(5,'保险箱');

insert into HouseFacilitiesDetails(hfId,hfdName) values 
(6,'有窗户'),(6,'落地窗'),(6,'电梯'),(6,'私家花园'),(6,'私家泳池'),
(6,'观景露台'),(6,'私家温泉');

insert into HouseFacilitiesDetails(hfId,hfdName) values 
(7,'餐厅'),(7,'超市'),(7,'提款机提款机'),(7,'药店'),
(7,'免费停车'),(7,'菜市场'),(7,'儿童乐园'),
(7,'泳池'),(7,' 公共花园');

insert into HouseFacilitiesDetails(hfId,hfdName) values 
(8,'行李寄存'),(8,'急救包');


#对房客的要求表
insert into homeRequirement(hreName) values
('允许吸烟'), 
('允许带宠物'), 
('允许做饭'), 
('允许聚会'), 
('允许加人'), 
('允许商业拍摄'), 
('允许房客加床');

#认证方式
insert into identityAction(iaName) values ('身份证'),('护照'),('营业执照');


-- 开始入信息

#管理员注册表
insert into regsistAdmin(raName,raPhone,raEmail,raPassword,raRole) values
('老张','16565465654','736375819@qq.com','123456','超级管理员'),
('老罗','15966465654','536375819@qq.com','123456','超级管理员'),
('老江','15865465654','636375819@qq.com','123456','普通管理员'),
('老东','16765465654','736375819@qq.com','123456','超级管理员'),
('老西','15665465654','836375819@qq.com','123456','普通管理员');
select *from regsistAdmin;

#用户个人信息(注册)表   --改动未更新
insert into userInformation(uPhone,uPassword,upicture,uNickName,uEmail,uTime,uName,uSex
,uAge,uDocumentType,uCardId,uNation,uConstellation,uBloodType,uProvince,uCity
,uOccupation,uDesc,uState) values
('13926901501',MD5('111111'),'upicture/头像','珠海铃声','111111111@qq.com','2019-02-12','胡英雄',0,18,'身份证','360428200202082211','汉族','水瓶座','A型','江西省','九江市','专业服务/教育/培训','跑步,登山,养花,电影',1),
('15070231020',MD5('111111'),'upicture/头像','天居路人','4399228799@qq.com','2018-11-10','润公索',0,32,'身份证','360428198711201124','汉族','天蝎座','B型','广东省','珠海市','贸易/消费/制造/营运','钓鱼,品茶,摄影,电影',1),
('18070131080',MD5('111111'),'upicture/头像','包租公','3602428299@qq.com','2019-01-15','吴应龙',0,20,'身份证','360428199902221254','汉族',' 双鱼座','O型','广东省','珠海市','会计/金融/银行/保险','足球,篮球,游泳,唱歌,美食',0),
('18070437080',MD5('111111'),'upicture/头像','落红物','1601128799@qq.com','2019-02-01','映山红',1,16,'身份证','360428200210201634','汉族','天秤座','AB型','广东省','珠海市','广告/媒体','钓鱼,品茶',1),
('13071237080',MD5('111111'),'upicture/头像','三十','2608428799@qq.com',now(),'于小红',1,28,'身份证','360428199110201114','汉族','天秤座','O型','广东省','珠海市','广告/媒体','',1)
;

#房屋全部信息表（房源表）
insert into homeAllInformation(uiId) values(1),(1),(1),(2),(2),(3);

#房屋位置表
insert into houseSite(hsProvince,hsCity,hsArea,hsSite,hsSupplementary,hsHouseNumber,hsLongitude,hsLatitude,haiId) 
values('广西','柳州','城中区','柳发123宿舍区','万达广场对面','42号',24.306997,109.42731,1),
('广西','柳州','诚中区','八一路','地王公馆','26-1号',24.322604,109.411412,2),
('广西','柳州','柳北区','北站路','地王公馆','26',21.482455,109.123748,3),
('广西','柳州','诚中区','立新路','地王公馆','30号',24.331264,109.418167,4),
('广西','柳州','诚中区','广场路','地王公寓','10号',24.325983,109.415555,5),
('广西','柳州','柳北区','跃进路','地王公馆','44号',24.340845,109.41637,6)
;

#房屋户型表
insert into houseApartment(haBedroom,haBathroom,haLounage
,haKitchen,haBookStudy,haBalcony) values(1,1,1,1,1,1)
,(3,2,1,1,2,1),(3,2,1,1,0,0),(2,1,1,1,0,0),(1,1,1,1,0,0);

                       
#房屋详细表
insert into houseDetails(hdArea,hdLiveNumber
,hdHouseNumebr,rmId,htdId,hcId,haId,haiId) VALUES
(132.1,2,6,1,1,null,1,1),
(132.1,6,2,1,5,2,2,2),
(152.1,8,3,1,5,2,3,3),
(102.1,3,5,1,3,3,4,4),
(82.1,2,6,1,13,2,5,5)
;

insert into houseDetails(hdArea,hdLiveNumber
,hdHouseNumebr,rmId,htdId,hcId,haId,haiId) VALUES
(82.1,2,6,1,13,2,5,6);

#床型表(一个房子有多个床型),关联房屋详细表
insert into housebed(hdId,hdsId,hbtNumber) values
(1,1,1),(1,2,1),(2,3,2),(2,1,2),(2,4,2),(3,11,4),(3,21,4)
,(4,20,2),(4,32,1),(5,11,2);

#房屋描述表
insert into housedecription(hdpName,hdpCharacteristic,hdpTraffic,hdpRound,haiId) VALUES
('CBD地王公馆~超美夜景的伊家公寓可做饭','软装风格','楼下有30多路公交车车站，不管您想去柳州的那个地方都非常方便。 去火车站有快1路.快2路.2路.5路.10路.11路.14路.16路.24路.27路.92路。 去园博园，卡乐星球，柳州科技大学，柳东雒容方向有快1路.80路。 去柳北，雀山公园方向有1路。 去大龙潭景区，白莲洞景区，飞机场方向有21路.19路.24路.9路。 去东环路，鱼峰山景区有6路.36路。 交通 距离柳州市白莲机场23公里，打车预计54元 距离柳州高铁站3.9公里，打车预计11元 距离柳州市白沙客运站5公里，打车预计14元 距离柳州市长途汽车站4.1公里，打车预计10元 距离柳州市汽车总站6公里，打车预计9元 景区 距离柳候公园500米 距离白莲洞景区13.7公里，打车预计30元 距离柳州大龙潭公园风景区6.5公里，打车预计20元 距离柳州卡乐星球欢乐世界14.3公里，打车预计30元 距离百里柳江上船点2.5公里，打车预计8元 其他的就不一一列出来了'
,'楼下有步步高商场 品牌服饰，鞋子，化妆品的（1-3楼），（ 海底捞等美食（4-6楼）， 步步高超市，小吃一条街（负一楼）， 华夏银都电影院（6楼）。 距柳州人民广场仅有500米，（人民广场晚上非常热闹，周末还有音乐喷泉呢） 距柳州最老也是最热闹的步行街仅800米。（步行街内有2家本地最大最老的商场，有出名的美食一条街，有几家本地非常出名的KTV等等） 金融机构：中国工商银行，中国邮政银行，中国光大银行，中国交通银行，中国招商银行，中国农业银行等 医疗服务机构：柳州市妇幼保健院，柳州市中医院 1公里范围内KTV，商场，银行，小吃街，景点（百里柳江，柳江明珠，柳候公园，东门古城楼）等一应俱全。'
,1)
,('柳州斯维登雍和宫红云阁温馨大床房','家居配套','公交车：32路万利花园站，步行200米。 62路万利花园站，步行200米。 68路万利花园站，步行200米。 25路银山小区站，步行400米。'
,'【房屋周围】步行1分钟：春季的紫荆花开放，楼下是一片花海。(柳州花季必游景点之一） 【银行】步行2分钟：工行、建行、中国银行、农行、柳州银行 【特色小吃】步行3分钟：度林膳螺蛳粉（老店必吃）、粤丰烧卤饭、煎饺、蒸米饺、河池煮粉、桂林米粉等特色小吃店 【商超】步行10分钟：柳南万达、大润发、万大菜市场、银山菜市场 【医院】打车5分钟：工人医院 【景点】打车10分钟：鱼峰山公园、胡志明旧居、马鞍山公园、文庙、东门、西来寺、五星步行街、水上公交、柳侯公园、龙潭公园、东堤路沙角十里画廊、柳江喷泉、柳州市博物馆等， 打车20分钟：窑埠古镇、柳州市工业博物馆、市政广场等 【柳州火车站】打车15分钟：火车站 【柳州机场】打车20分钟：机场 【景点游玩】打车30分钟：园博园、卡乐星球 【学校】步行5分钟：银山小学 【公交】公交车站32.62.68.25路',2)
,('柳州斯维登机场新国展标准大床房','家居配套','【交通】 位于城市交通的枢纽 路经的公交：快1、快2、快3、快6、快8、2路、16路、92路、18路、19路、24路、80路 『火车站』：快2路公交车到^人民广场站^下车 『机场』：建议直接打滴滴 『柳州会展中心』：快1路公交车到^会展中心^下车 『窑埠古镇』：快3路公交车到^文昌路西^下车 『卡乐星球欢乐世界』：80路公交车到^卡乐星球^下车 【停车场】就在楼下噢~'
,'『大排档美食城』：楼下往北50米 『南北风味一条街』：楼下商场负一层 『大型生鲜蔬菜超市』：楼下商场负一层',3)
,('柳州高新区近环江风景文源华都紫京城','物业管理','位于壶东大桥旁凯旋大道上，保利大江郡二期保利广场旁。小区配备：玫瑰园 / 凯旋门广场 / 水上运动会 / 游泳池 / 棋艺馆 / 高尔夫体验馆 / 亲子圆等 交通便利，小区出门口右侧就是公交车站100路，另白沙路35中学路段有多条公交线路转乘车100路，方便出行。'
,'小区配备充足的地下停车场收费车位；保安物业管理安全有序，24小时保安巡视，出入需刷门禁卡。配备进口品牌电梯，楼盘干净整洁，植被整齐优美。商业配套齐全，菜市，多家超市，多家美食中心；附近有多家银行。',4)
,('保利大江郡豪奢商务三房中央空调洗衣机','软装风格','柳州东城区西花市大街新景家园'
,'一套房适合3-6人入住。标准入住四人，超过四人的话，每超过一人每天加收五十元，五岁以下不计算人数。套房内有里外间，房间面积为65平米。',5)
,('爱丽莎ins 江景52号公寓','软装风格','交通情况： 机场：小区离柳州候机楼2公车站距离，步行10分钟，小区直达柳州白云机场出租车大概40元，时间30分钟。柳州到桂林两江机场大巴为整点出发（6:00-20:00）大概1小时50分钟！ 火车站：即使高峰期打车难，火车站出站口右手边可乘坐快2等公交车到柳州市广场东路下车（共6站），高峰期一定记得坐快2（下午5:30-7:00） 汽车站：乘坐快2到柳州市广场东下车（共5站）'
,'其他：小区门口大型公交车站，通往市内，新区都无需转车。 小区周边大型商场2个，大型影院1个，儿童城1个，星巴克咖啡，各种特色小吃，大小餐馆一应俱全，给您的工作，生活及出行带来极大的帮助，房东为老柳州人，一定会给您一个不一样的旅途！快来入住我的房子吧！这里就是家！',6)
;
select * from housedecription;


  select * from picturetype as t join picture as p join homeAllInformation as h on t.haiId=h.haiId and t.ptId=t.ptId where t.haiId=3;

#设施服务表对应表  --改动未更新姐妹们
insert into HouseFacilitiesReflect(haiId,hfdId) VALUES (1,1),(1,3),(1,5),(1,7),(1,9),(1,10),(1,11),(1,13),(1,15),(1,16),(1,17),(1,22)
,(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,40),(1,41),(1,42),(1,43),(1,51),(1,52),(1,54),(1,55),(1,59),(1,61),(1,63),(1,68),(1,80)
,(2,3),(2,5),(2,7),(2,8),(2,9),(2,22),(2,11),(2,12),(2,24),(2,25),(2,13),(2,15),(2,17)
,(3,2),(3,3),(3,4),(3,4),(3,6),(3,61),(3,63),(3,68),(3,80)
,(4,3),(4,5),(4,7),(4,8),(4,9),(4,22),(4,11),(4,12),(4,24),(4,25)
,(5,3),(5,5),(5,7),(5,8),(5,9),(5,22),(5,11),(5,12),(5,24),(5,25),(5,26),(5,35),(5,47)
,(6,3),(6,5),(6,7),(6,8),(6,9),(6,22),(6,11),(6,12),(6,24),(6,25),(6,26),(6,35),(6,47),(6,48),(6,49),(6,56),(6,55),(6,57)
,(6,1),(6,2),(6,3),(6,5),(6,7),(6,8),(6,9),(6,17),(6,18),(6,19),(6,22),(6,11),(6,12),(6,24),(6,25)
,(6,26),(6,35),(6,47),(6,48),(6,49),(6,56),(6,55),(6,57),(6,61),(6,66),(6,65)
; 
#入住规则表
insert into homeRules(hrCheckIn,hrCheckOut,hrProscenium,hrSex,hrSpecialAge
,hrHygiene,hrSheets,hrTip,haiId) VALUES('14:00','12:00',1,0,0,'1客1扫','1客1换'
,'水电燃气费、额外打扫费用、入住所需证件',1)
,('14:00','12:00',1,0,0,'1客1扫','1客1换'
,'水电燃气费、额外打扫费用、入住所需证件',2)
,('14:00','12:00',1,0,0,'1客1扫','1客1换'
,'水电燃气费、额外打扫费用、入住所需证件',3)
,('14:00','12:00',1,0,0,'1客1扫','1客1换'
,'水电燃气费、额外打扫费用、入住所需证件',4)
,('14:00','12:00',1,0,0,'1客1扫','1客1换'
,'水电燃气费、额外打扫费用、入住所需证件',5)
,('14:00','12:00',1,0,0,'1客1扫','1客1换'
,'水电燃气费、额外打扫费用、入住所需证件',6)
;

#接待房客时间表(关联入住规则表)
insert into receptionTime(rtStartTime,rtEndTime,hrId ) values ('00:00','24:00',1)
,('00:00','24:00',2)
,('12:00','20:00',3)
,('00:00','24:00',4)
,('00:00','24:00',5)
,('12:00','20:00',6)
;

insert into receptionTime(rtStartTime,rtEndTime,hrId ) values ('07:00','9:00',1);

#对房客的要求表对应表(与房客要求表和入住规则表进行关联)
insert into homeRequirementReflect(hrId,hreId) values(1,2),(1,7),(1,1)
,(2,1),(3,2),(4,1),(4,2),(5,2),(5,7),(5,6),(6,6),(6,7)
;

#房屋图片表类型
insert into picturetype(haiId,ptName) values
(1,'卧室'),(1,'客厅'),(1,'卫生间'),(1,'阳台'),(1,'书房'),(1,'厨房')
,(2,'卧室'),(2,'客厅'),(2,'卫生间'),(2,'阳台'),(2,'书房'),(2,'厨房')
,(3,'卧室'),(3,'客厅'),(3,'卫生间'),(3,'阳台')
,(4,'卧室'),(4,'客厅'),(4,'卫生间'),(4,'阳台')
,(5,'卧室'),(5,'客厅'),(5,'卫生间'),(5,'阳台')
;
insert into picturetype(haiId,ptName) values(6,'卧室');
#房屋图片表 
select * from homeAllInformation;
select * from picturetype;

insert into picture(ptId,pUrl,pPagePicture) values (25,'08f22157b.jpg',0);

insert into picture(ptId,pUrl,pPagePicture) values (1,'08f22157b.jpg',0);
insert into picture(ptId,pUrl,pPagePicture) values
(1,'08f22157-16f4-496f-81ac-36573dcada9b.jpg',1)
,(2,'d1316854-23e4-4db8-9f13-2a4cc3b835a6.jpg',0)
,(3,'a79a8a5d-12a2-44e3-abe4-a68d3fc3fd9a.jpg',0)
,(4,'6404f668-5d28-430a-9c51-4138c29acfee.jpg',0)
,(6,'75c9c006-c7af-475a-9cdb-13e349a29457.jpg',0)

,(7,'01e1a5df-8708-4f0d-8f65-3c0a23f8f677.jpg',1)
,(7,'c2b8b7ae308139d4b77dd010ae702035.jpg',0)
,(7,'b04fc8e8ea2acb6c3986b23efcda6958.jpg',0)
,(8,'a84ac7b1-b09e-434b-9bf7-be292a01a056.jpg',0)
,(9,'6bd0096a-3cb8-4d93-ae3e-5793983df338.jpg',0)
,(10,'28ae2d39-5928-4195-abb6-b83266afb4de.jpg',0)
,(11,'7bfc27b2-5dcf-4aac-a15c-43b2ac9a7def.jpg',0)
,(12,'90306a76-4dbc-4724-9147-8072fe2e3c73.jpg',0)

,(13,'931c8ced-a8d0-4aa2-8b8c-138938006feb.jpg',1)
,(14,'74256d1e-3ab5-44f3-b57d-ee78a0a93d54.jpg',0)
,(15,'0920e66d-b00d-40cf-b801-74f6dbbcd5af.jpg',0)

,(17,'61049836-038f-4306-9921-8f76fffd77c6.jpg',1)
,(18,'dd2b3e3a-96a0-4e2a-92a3-82c48de74cfe.jpg',0)
,(19,'79c7f2b6-3b18-4471-8930-a966c13b02a3.jpg',0)
,(20,'c164bde3-d6ac-4400-b1d6-c15af33bf451.jpg',0)

,(21,'f07fc23d-5f07-4142-8928-a53e7c0d9b95.jpg',1)
,(22,'76ff8514-3c40-491b-be5f-22da5ff06d72.jpg',0)
,(23,'f3d0bdea-93b8-4ba4-816a-aa9fca3be16b.jpg',0)
,(24,'aaeab340-414f-4386-be72-caa11a7045e3.jpg',0)
;

#房屋价格表
insert into homeprice(hpPrice,cdLeastDay,cdDeposit,cdFullRefund,cdSomeRefund
,cdThreeDiscount,haiId)
values(298.0,1,300,1,0.5,8.0,1)
,(398.0,2,400,1,0.5,8.0,2)
,(258.0,1,200,1,0.5,8.0,3)
,(228.0,1,260,1,0.5,8.0,4)
,(238.0,1,400,1,0.5,8.0,5)
,(268.0,1,280,1,0.5,8.0,6)
;


#连住折扣表

insert into continuousdiscount(cdDay,cdDiscount,hpId) values(2,0.9,1);
insert into continuousdiscount(cdDay,cdDiscount,hpId) values(7,0.8,1)
,(3,0.9,2)
,(5,0.85,3)
,(2,0.9,4)
,(1,0.8,5)
,(3,0.85,6)
;

#身份验证
insert into identityVerification(ivName,ivUrl,haiId)
values('地王公馆高层美少女系列大床房 超大落地窗','PCLZWVQ39BHVVA7LA6T8ZMV2ZGSU2V.jpg_150x150c.jpg',1)
,('美之馨公寓','5NHTTAKUPCFNVQXTD5GBJ3A9KQZ5QE.jpg_150x150c.jpg',2)
,('柳北三房两厅套房欧式奢美装修商务休闲皆宜','QMC62NNCGZKBKNBNX4WCJGPH8WNPM2.jpg_150x150c.jpg',3)
,('市中心 地王公馆 高层视野江景房','5MMKG8PCA2H8HJZBCDGFKJNSCAFA9M.jpg_150x150c.jpg',4)
,('婉约格调大床房','EXAV83XJZE323MYYZUMTRPRP9U2XYU.jpg_150x150c.jpg',5)
,('江景地中海风格大一房','7AYP93CDAS6EKUMY8AALFY8AKB69NC.jpg_150x150c.jpg',6)
;

#房屋多种价格对应表(一栋房子有多种不同的价格，在当天前的为无房，如果设置了价格那么价格就为设置的，否则价格为默认价格，即初始价格即可)，（多对一关系）
insert into priceReflect(prPrice,prTime,haiId) values
(230,'2019-06-07',1)
,(230,'2019-06-08',1)
,(230,'2019-06-09',1)
,(230,'2019-06-10',1)
,(230,'2019-06-11',1)
,(230,'2019-06-07',1)
,(230,'2019-06-07',2)
,(200,'2019-03-07',3)
,(300,'2019-02-07',4)
,(190,'2019-02-07',5)
,(320,'2019-06-07',6)
;

#预定信息
insert into reserve(rvSerialNumber,rvBelowOrder,rvStartTime,rvEndTime,rvTotalDay
,rvHouseNumeb,uiId,rvInvoice,rvLiveNumber,rvPayState,rvHomeState,haiId)
values ('1111111111111','2019-03-01 00:00:00','2019-02-23 00:00:00'
,'2019-03-08 00:00:00',9,3,1,1,5,1,2,1)
,('1111111111112','2019-03-01 00:00:00','2019-02-23 00:00:00'
,'2019-03-08 00:00:00',9,2,1,1,5,1,2,1)
,('1111111111113','2019-03-01 00:00:00','2019-03-02 00:00:00'
,'2019-03-08 00:00:00',9,1,2,1,5,1,2,1);



#收藏表
insert into collections(haiId,uiId) values(1,1),(1,2),(1,3);


##第一间房子的评价
insert into evaluate(eHygiene,eTraffic,eEnvironmental,eService,eCostPerformance,eEvaluateContent,eAnswerContent,haiId,uiId)
values(5,4,5,5,4,'环境很好，离四方街很近，出去玩很方便。房间装修挺好的，古色古香，房间宽敞明亮，浴室也挺大挺干净的，洗漱用品齐全，总体满意。
','',1,1);
insert into evaluate(eHygiene,eTraffic,eEnvironmental,eService,eCostPerformance,eEvaluateContent,eAnswerContent,haiId,uiId)
values(4,3,5,5,4,'两个人来玩挺不错，交通便利，环境优美。房间宽敞明亮，干净整洁，生活用品齐全，热水充足，洗澡舒服。晚上睡觉安静。
','',1,2);
insert into evaluate(eHygiene,eTraffic,eEnvironmental,eService,eCostPerformance,eEvaluateContent,eAnswerContent,haiId,uiId)
values(5,5,5,5,5,'环境优美，房间舒适卫生，服务人员很热情，乐于提供各种帮助，设施很人性化，房间的设计也很有特色。下次还要入住。
','',1,3);

##第二间房子的评价
insert into evaluate(eHygiene,eTraffic,eEnvironmental,eService,eCostPerformance,eEvaluateContent,eAnswerContent,haiId,uiId)
values(5,4,5,5,4,'住的房间很舒服，房间设计很合理干湿分离，房间可以观看到外面的小河，看起来特别美丽，观赏美景，服务态度一定要赞一个。
','',2,1);
insert into evaluate(eHygiene,eTraffic,eEnvironmental,eService,eCostPerformance,eEvaluateContent,eAnswerContent,haiId,uiId)
values(4,3,5,5,4,'周围环境不错，里面装修很温馨，干净整洁干净舒适住着，老板服务热情周到，交通非常方便，是出门旅行的不错选择。
','',2,2);

select count(distinct hai.haiId) from homeAllInformation hai -- 用户 
left join userInformation ui on ui.uiId=hai.uiId -- 房屋位置 
left join houseSite hs on hai.haiId=hs.haiId -- 房屋详细表 
left join houseDetails hd on hai.haiId=hd.haiId -- 床型 
left join houseBed hb on hd.hdId=hb.hdId left join houseBedSize hbs on hb.hdsId=hbs.hdsId left join houseBedType hbt on hbt.hbtId=hbs.hbtId -- 出租方式表 
left join rentalMode rm on hd.rmId=rm.rmId -- 关联房屋类型 
left join houseTypeDetails htd on hd.htdId=htd.htdId -- 房屋类型
 left join houseType ht on ht.htId=htd.htId -- 房屋景观
 left join houseScenery hsc on hsc.hcId=hd.hcId -- 房屋户型【卧室、卫生间、客厅、厨房、书房、阳台】 
 left join houseApartment ha on ha.haId=hd.haId -- 房屋描述
 left join houseDecription hdp on hdp.haiId=hai.haiId -- 设施服务
 left join HouseFacilitiesReflect hfr on hfr.haiId=hai.haiId left join HouseFacilitiesDetails hfd on hfr.hfdId=hfd.hfdId left join HouseFacilities hf on hfd.hfId=hf.hfId -- 入住规则 
 left join homeRules hr on hr.haiId=hai.haiId left join homeRequirementReflect hrr on hrr.hrId=hr.hrId left join homeRequirement hre on hrr.hreId=hre.hreId left join receptionTime rt on rt.hrId=hr.hrId -- 房屋照片 
 left join pictureType pt on pt.haiId=hai.haiId left join picture p on p.ptId=pt.ptId -- 价格设置
 left join homePrice hp on hp.hpId=hai.haiId left join continuousDiscount cd on hp.hpId=cd.hpId -- 身份验真
 left join identityVerification iv on iv.haiId=hai.haiId -- 评论数 
 left join evaluate r on r.uiId=hai.uiId -- 预定
 left join reserve rv on rv.haiId=hai.uiId 
 WHERE hs.hsCity='柳州' and (hpPrice >=60 and hpPrice <=1000);
