drop table if exists android_metadata;

create table android_metadata (
	locale TEXT DEFAULT 'en_US'
);

insert into android_metadata values ('en_US');

-- AGENCY
drop table if exists agency;

create table agency (
  _id      integer primary key,
  name    text,
  label   text,
  address text,
  longitude double,
  latitude  double,
  phone     text
);

-- OK
insert into agency values(0, "Paris",  "SQLI (siège social)", " 268 avenue du Président Wilson<br>93210 La Plaine Saint-Denis", 2.358401, 48.91948, "0155932600");

-- OK
insert into agency values(1, "Bordeaux",  "SQLI Enterprise", "198 avenue du Haut Leveque<br>Enora Park, Bâtiment 2<br>33600 Pessac", -0.650608, 44.782404, "0556077640");

-- OK
insert into agency values(2, "Boulogne-Billancourt",  "SQLI Institut", "47-49 avenue Edouard Vaillant<br>92100 Boulogne-Billancourt", 2.250952, 48.835525, "0146100440");

-- OK
insert into agency values(3, "Arcueil",  "Aston Ecole", "19-21 rue du 8 mai 1945<br>94110 ARCUEIL", 2.329454, 48.801029, "0145361520");

-- OK
insert into agency values(4, "Lyon",  "SQLI Enterprise", "1 place Verrazzano<br>CP 611<br>69258 Lyon Cedex 09", 4.813273, 45.787619, "0472405353");

-- OK
insert into agency values(5, "Nantes",  "SQLI Enterprise", "Parc du Leinster<br>Bâtiment Le Baltimore<br>10/12 rue de Laponie<br>44240 La Chapelle sur Erdre", -1.549141, 47.276543, "0251797740");

-- OK
insert into agency values(6, "Toulouse",  "SQLI Enterprise", "6 impasse de Lisieux<br>CS43133<br>31026 Toulouse Cédex 3", 1.396056, 43.597746, "0562477070");

-- PAS OK... les coordonnees sont pas bonnes
insert into agency values(7, "London",  "SQLI Inventcommerce", " 8a Great Newport Street<br>WC2H 7JA London", 0, 0, "+442030115000");

-- OK
insert into agency values(8, "Belgium",  "SQLI Belgium", "Lambroekstraat 5C<br>BE - 1831 Diegem", 4.451105, 50.880574, "+3223046223");
