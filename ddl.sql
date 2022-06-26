create table bookmaker
(
	id integer not null
		constraint bookmaker_pkey
			primary key,
	name varchar(255),
	created_date timestamp
);

alter table bookmaker owner to admin;

create table country
(
	id integer not null
		constraint country_pkey
			primary key,
	name varchar(255),
	created_date timestamp
);

alter table country owner to admin;

create table league
(
	id integer not null
		constraint league_pkey
			primary key,
	name varchar(255),
	country_id integer
		constraint fktdt2rqg50rlqti7yubvppq25e
			references country,
	created_date timestamp
);

alter table league owner to admin;

create table team
(
	id integer not null
		constraint team_pkey
			primary key,
	name varchar(255),
	country_id integer
		constraint fkqv6wvrq3qclb3gvo92gg2y6q7
			references country,
	created_date timestamp
);

alter table team owner to admin;

create table match
(
	id integer not null
		constraint match_pkey
			primary key,
	time timestamp,
	away_team_id integer
		constraint fksyjor2anx7bkbst7ebyw13jcs
			references team,
	home_team_id integer
		constraint fk6ihefb9r7f0fcm0xuves72b2l
			references team,
	league_id integer
		constraint fkav702gcmwu2x0q7b4yxbia86n
			references league,
	created_date timestamp
);

alter table match owner to admin;

create table bookmaker_match
(
	id varchar(255) not null
		constraint bookmaker_match_pkey
			primary key,
	created_date timestamp not null,
	active boolean not null,
	last_updated_date timestamp,
	live_betting boolean not null,
	odds_type integer,
	bookmaker_id integer
		constraint fkgb86c8nmd3u9je5fum830kds6
			references bookmaker,
	match_id integer
		constraint fk3j94ep010mv0v7qtsefiwlkkv
			references match
);

alter table bookmaker_match owner to admin;

create table odds
(
	odds_type integer not null,
	id varchar(255) not null
		constraint odds_pkey
			primary key,
	created_date timestamp not null,
	updated_date timestamp,
	away double precision,
	draw double precision,
	home double precision,
	over double precision,
	under double precision,
	bookmaker_match_id varchar(255)
		constraint fkagrmicoxci0nhl99nrm4dyup2
			references bookmaker_match
);

alter table odds owner to admin;

