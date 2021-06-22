create table credential.user
(
	id int not null
		constraint user
			primary key,
	username varchar(20) not null,
	email varchar(100) not null,
	password varchar(200) not null,
	full_name varchar(200),
	enabled bool default false not null,
	account_expired_status bool default false not null,
	account_locked_status bool default false not null,
	credentials_expired_status bool default false not null
);
create table credential.role
(
	id int not null,
	name varchar(20) not null
);

create unique index role_id_uindex
	on credential.role (id);

alter table credential.role
	add constraint role_pk
		primary key (id);

