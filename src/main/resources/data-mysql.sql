use trader;

delete from future;
delete from storage;
delete from transport;
delete from hub;

insert into hub(id,name) values
(1,"Amsterdam"),(2,"Hong Kong"),(3,"Sydney"),(4,"London");

insert into storage(capacity, price, hub_id) values
(200,0.07,1),(170,0.08,2),(50,0.09,3),(60,0.05,3),(150,0.1,4);

insert into transport(capacity, duration, price, from_id, to_id) values
(100,12,55,1,2),
(100,15,65,1,3),
(100,2,15,1,4),
(100,12,55,2,1),
(100,5,30,2,3),
(100,13,45,2,4),
(100,15,65,3,1),
(100,4,30,3,2),
(100,15,65,3,4),
(100,2,15,4,1),
(100,13,45,4,2),
(100,15,65,4,3);

insert into `future` values
(1,_binary '','2022-06-26',100.00,100,5,1),
(2,_binary '','2022-07-03',125.35,100,5,1),
(3,_binary '','2022-07-10',117.31,100,5,1),
(4,_binary '','2022-07-17',96.88,100,5,1),
(5,_binary '','2022-07-24',93.49,100,5,1),
(6,_binary '','2022-07-31',69.03,100,3,2),
(7,_binary '','2022-08-07',22.32,100,3,2),
(8,_binary '','2022-08-14',46.25,100,3,2),
(9,_binary '','2022-06-27',66.26,100,5,2),
(10,_binary '','2022-07-04',55.43,100,5,2),
(11,_binary '','2022-07-11',95.34,100,5,2),
(12,_binary '','2022-07-18',90.49,100,6,3),
(13,_binary '','2022-07-25',32.28,100,6,3),
(14,_binary '','2022-08-01',63.91,100,6,3),
(15,_binary '','2022-08-08',39.32,100,6,3),
(16,_binary '','2022-08-15',94.89,100,6,3),
(17,_binary '','2022-06-28',92.19,100,5,3),
(18,_binary '','2022-07-05',87.25,100,5,3),
(19,_binary '','2022-07-12',112.21,100,5,3),
(20,_binary '','2022-06-27',55.36,100,8,4),
(21,_binary '','2022-07-04',99.72,100,8,4),
(22,_binary '','2022-07-11',97.52,100,8,4),
(23,_binary '','2022-07-18',146.89,100,8,4),
(24,_binary '','2022-07-25',104.26,100,2,4),
(25,_binary '','2022-08-01',101.62,100,2,4),
(26,_binary '','2022-08-08',150.25,100,2,4),
(27,_binary '','2022-08-15',126.48,100,5,4),
(28,_binary '','2022-06-28',175.66,100,5,4),
(29,_binary '','2022-07-05',129.89,100,5,4),
(30,_binary '','2022-07-12',121.18,100,5,4),
(31,_binary '','2022-07-19',79.69,100,5,4),
(32,_binary '','2022-07-26',60.81,100,5,4),
(33,_binary '','2022-08-02',113.36,100,5,4),
(34,_binary '','2022-08-09',106.19,100,5,4),
(35,_binary '','2022-08-16',140.93,100,5,4),
(36,_binary '\0','2022-06-26',191.95,100,5,1),
(37,_binary '\0','2022-07-03',217.39,100,5,1),
(38,_binary '\0','2022-07-10',175.59,100,5,1),
(39,_binary '\0','2022-07-17',178.09,100,5,1),
(40,_binary '\0','2022-07-24',191.80,100,5,1),
(41,_binary '\0','2022-07-31',189.66,100,3,2),
(42,_binary '\0','2022-08-07',243.06,100,3,2),
(43,_binary '\0','2022-08-14',228.88,100,3,2),
(44,_binary '\0','2022-06-27',215.08,100,5,2),
(45,_binary '\0','2022-07-04',224.83,100,5,2),
(46,_binary '\0','2022-07-11',216.21,100,5,2),
(47,_binary '\0','2022-07-18',221.34,100,6,3),
(48,_binary '\0','2022-07-25',198.21,100,6,3),
(49,_binary '\0','2022-08-01',187.32,100,6,3),
(50,_binary '\0','2022-08-08',156.48,100,6,3),
(51,_binary '\0','2022-08-15',187.26,100,6,3),
(52,_binary '\0','2022-06-28',206.50,100,5,3),
(53,_binary '\0','2022-07-05',157.28,100,5,3),
(54,_binary '\0','2022-07-12',151.34,100,5,3),
(55,_binary '\0','2022-06-27',118.27,100,8,4),
(56,_binary '\0','2022-07-04',103.88,100,8,4),
(57,_binary '\0','2022-07-11',55.25,100,8,4),
(58,_binary '\0','2022-07-18',19.15,100,8,4),
(59,_binary '\0','2022-07-25',25.61,100,2,4),
(60,_binary '\0','2022-08-01',20.61,100,2,4),
(61,_binary '\0','2022-08-08',40.43,100,2,4),
(62,_binary '\0','2022-08-15',23.84,100,5,4),
(63,_binary '\0','2022-06-28',26.11,100,5,4),
(64,_binary '\0','2022-07-05',21.13,100,5,4),
(65,_binary '\0','2022-07-12',49.38,100,5,4),
(66,_binary '\0','2022-07-19',56.91,100,5,4),
(67,_binary '\0','2022-07-26',61.31,100,5,4),
(68,_binary '\0','2022-08-02',78.44,100,5,4),
(69,_binary '\0','2022-08-09',54.85,100,5,4),
(70,_binary '\0','2022-08-16',44.79,100,5,4),
(71,_binary '\0','2022-09-26',4.88,100,5,1),
(72,_binary '\0','2022-10-03',6.56,100,5,1),
(73,_binary '\0','2022-10-10',30.64,100,5,1),
(74,_binary '\0','2022-10-17',27.34,100,5,1),
(75,_binary '\0','2022-10-24',20.84,100,5,1),
(76,_binary '\0','2022-10-31',40.38,100,3,2),
(77,_binary '\0','2022-11-07',34.69,100,3,2),
(78,_binary '\0','2022-11-14',49.80,100,3,2),
(79,_binary '\0','2022-11-21',50.30,100,5,2),
(80,_binary '\0','2022-11-28',113.06,100,5,2),
(81,_binary '\0','2022-12-05',97.55,100,5,2),
(82,_binary '\0','2022-12-12',156.53,100,6,3),
(83,_binary '\0','2022-12-19',146.93,100,6,3),
(84,_binary '\0','2022-12-26',143.97,100,6,3),
(85,_binary '\0','2023-01-02',164.86,100,6,3),
(86,_binary '\0','2023-01-09',138.57,100,6,3),
(87,_binary '\0','2023-01-16',89.27,100,5,3),
(88,_binary '\0','2023-01-23',100.77,100,5,3),
(89,_binary '\0','2023-01-30',74.76,100,5,3),
(90,_binary '\0','2023-02-06',53.81,100,8,4),
(91,_binary '\0','2023-02-13',30.98,100,8,4),
(92,_binary '\0','2023-02-20',18.47,100,8,4),
(93,_binary '\0','2023-02-27',36.57,100,8,4),
(94,_binary '\0','2023-03-06',35.27,100,2,4),
(95,_binary '\0','2023-03-13',80.19,100,2,4),
(96,_binary '\0','2023-03-20',90.30,100,2,4),
(97,_binary '\0','2023-03-27',87.24,100,5,4),
(98,_binary '\0','2023-04-03',107.65,100,5,4),
(99,_binary '\0','2023-04-10',158.35,100,5,4),
(100,_binary '\0','2023-04-17',109.49,100,5,4),
(101,_binary '\0','2023-04-24',128.99,100,5,4),
(102,_binary '\0','2023-05-01',133.08,100,5,4),
(103,_binary '\0','2023-05-08',130.84,100,5,4),
(104,_binary '\0','2023-05-15',63.44,100,5,4),
(105,_binary '\0','2023-05-22',87.68,100,5,4),
(106,_binary '\0','2023-05-29',99.38,100,5,1),
(107,_binary '\0','2023-06-05',68.71,100,5,1),
(108,_binary '\0','2023-06-12',73.15,100,5,1),
(109,_binary '\0','2023-06-19',67.23,100,5,1),
(110,_binary '\0','2023-06-26',57.34,100,5,1),
(111,_binary '\0','2023-07-03',43.56,100,3,2),
(112,_binary '\0','2023-07-10',56.29,100,3,2),
(113,_binary '\0','2023-07-17',33.01,100,3,2),
(114,_binary '\0','2023-07-24',40.02,100,5,2),
(115,_binary '\0','2023-07-31',12.40,100,5,2),
(116,_binary '\0','2023-08-07',8.79,100,5,2),
(117,_binary '\0','2023-08-14',69.39,100,6,3),
(118,_binary '\0','2023-08-21',73.02,100,6,3),
(119,_binary '\0','2023-08-28',68.06,100,6,3),
(120,_binary '\0','2023-09-04',81.88,100,6,3),
(121,_binary '\0','2023-09-11',113.26,100,6,3),
(122,_binary '\0','2023-09-18',114.78,100,5,3),
(123,_binary '\0','2023-09-25',122.19,100,5,3),
(124,_binary '\0','2023-10-02',124.82,100,5,3),
(125,_binary '\0','2023-10-09',128.08,100,8,4),
(126,_binary '\0','2023-10-16',171.92,100,8,4),
(127,_binary '\0','2023-10-23',134.68,100,8,4),
(128,_binary '\0','2023-10-30',139.11,100,8,4),
(129,_binary '\0','2023-11-06',128.83,100,2,4),
(130,_binary '\0','2023-11-13',66.29,100,2,4),
(131,_binary '\0','2023-11-20',56.33,100,2,4),
(132,_binary '\0','2023-11-27',34.13,100,5,4),
(133,_binary '\0','2023-12-04',43.86,100,5,4),
(134,_binary '\0','2023-12-11',79.41,100,5,4),
(135,_binary '\0','2023-12-18',82.04,100,5,4),
(136,_binary '\0','2023-12-25',82.26,100,5,4),
(137,_binary '\0','2024-01-01',94.82,100,5,4),
(138,_binary '\0','2024-01-08',120.96,100,5,4),
(139,_binary '\0','2024-01-15',174.72,100,5,4),
(140,_binary '\0','2024-01-22',163.81,100,5,4),
(141,_binary '\0','2024-01-22',163.81,100,2,1);