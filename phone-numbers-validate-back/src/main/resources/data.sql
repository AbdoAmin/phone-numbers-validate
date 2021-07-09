insert into users (username, password, enabled) values ('admin', '{noop}admin', true);
insert into users (username, password, enabled) values ('user', '{noop}user', true);
INSERT INTO users  (username, password, enabled)
values ('abdo',
        '{bcrypt}$2a$10$jhyTO4zyD1fmaLVZZn9irOgEJnHAExaNYcFTy2cIv2chUEQUNHaei', -- abdo
        1);

insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('abdo', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('abdo', 'ROLE_ADMIN');


INSERT INTO country (name,phone_regex) values ('Cameroon','\(237\)\ ?[2368]\d{7,8}$');
INSERT INTO country (name,phone_regex) values ('Ethiopia','\(251\)\ ?[1-59]\d{8}$');
INSERT INTO country (name,phone_regex) values ('Morocco','\(212\)\ ?[5-9]\d{8}$');
INSERT INTO country (name,phone_regex) values ('Mozambique','\(258\)\ ?[28]\d{7,8}$');
INSERT INTO country (name,phone_regex) values ('Uganda','\(256\)\ ?\d{9}$');

INSERT INTO customer (id, name,phone) values ('0','Walid Hammadi' , '(212) 6007989253');
INSERT INTO customer (id, name,phone) values ('1','Yosaf Karrouch' , '(212) 698054317');
INSERT INTO customer (id, name,phone) values ('2','Younes Boutikyad' , '(212) 6546545369');
INSERT INTO customer (id, name,phone) values ('3','Houda Houda' , '(212) 6617344445');
INSERT INTO customer (id, name,phone) values ('4','Chouf Malo' , '(212) 691933626');
INSERT INTO customer (id, name,phone) values ('5','soufiane fritisse ' , '(212) 633963130');
INSERT INTO customer (id, name,phone) values ('6','Nada Sofie' , '(212) 654642448');
INSERT INTO customer (id, name,phone) values ('7','Edunildo Gomes Alberto ' , '(258) 847651504');
INSERT INTO customer (id, name,phone) values ('8','Walla''s Singz Junior' , '(258) 846565883');
INSERT INTO customer (id, name,phone) values ('9','sevilton sylvestre' , '(258) 849181828');
INSERT INTO customer (id, name,phone) values ('10','Tanvi Sachdeva' , '(258) 84330678235');
INSERT INTO customer (id, name,phone) values ('11','Florencio Samuel' , '(258) 847602609');
INSERT INTO customer (id, name,phone) values ('12','Solo Dolo' , '(258) 042423566');
INSERT INTO customer (id, name,phone) values ('13','Pedro B 173' , '(258) 823747618');
INSERT INTO customer (id, name,phone) values ('14','Ezequiel Fenias' , '(258) 848826725');
INSERT INTO customer (id, name,phone) values ('15','JACKSON NELLY' , '(256) 775069443');
INSERT INTO customer (id, name,phone) values ('16','Kiwanuka Budallah' , '(256) 7503O6263');
INSERT INTO customer (id, name,phone) values ('17','VINEET SETH' , '(256) 704244430');
INSERT INTO customer (id, name,phone) values ('18','Jokkene Richard' , '(256) 7734127498');
INSERT INTO customer (id, name,phone) values ('19','Ogwal David' , '(256) 7771031454');
INSERT INTO customer (id, name,phone) values ('20','pt shop 0901 Ultimo ' , '(256) 3142345678');
INSERT INTO customer (id, name,phone) values ('21','Daniel Makori' , '(256) 714660221');
INSERT INTO customer (id, name,phone) values ('22','shop23 sales' , '(251) 9773199405');
INSERT INTO customer (id, name,phone) values ('23','Filimon Embaye' , '(251) 914701723');
INSERT INTO customer (id, name,phone) values ('24','ABRAHAM NEGASH' , '(251) 911203317');
INSERT INTO customer (id, name,phone) values ('25','ZEKARIAS KEBEDE' , '(251) 9119454961');
INSERT INTO customer (id, name,phone) values ('26','EPHREM KINFE' , '(251) 914148181');
INSERT INTO customer (id, name,phone) values ('27','Karim Niki' , '(251) 966002259');
INSERT INTO customer (id, name,phone) values ('28','Frehiwot Teka' , '(251) 988200000');
INSERT INTO customer (id, name,phone) values ('29','Fanetahune Abaia' , '(251) 924418461');
INSERT INTO customer (id, name,phone) values ('30','Yonatan Tekelay' , '(251) 911168450');
INSERT INTO customer (id, name,phone) values ('31','EMILE CHRISTIAN KOUKOU DIKANDA HONORE ' , '(237) 697151594');
INSERT INTO customer (id, name,phone) values ('32','MICHAEL MICHAEL' , '(237) 677046616');
INSERT INTO customer (id, name,phone) values ('33','ARREYMANYOR ROLAND TABOT' , '(237) 6A0311634');
INSERT INTO customer (id, name,phone) values ('34','LOUIS PARFAIT OMBES NTSO' , '(237) 673122155');
INSERT INTO customer (id, name,phone) values ('35','JOSEPH FELICIEN NOMO' , '(237) 695539786');
INSERT INTO customer (id, name,phone) values ('36','SUGAR STARRK BARRAGAN' , '(237) 6780009592');
INSERT INTO customer (id, name,phone) values ('37','WILLIAM KEMFANG' , '(237) 6622284920');
INSERT INTO customer (id, name,phone) values ('38','THOMAS WILFRIED LOMO LOMO' , '(237) 696443597');
INSERT INTO customer (id, name,phone) values ('39','Dominique mekontchou' , '(237) 691816558');
