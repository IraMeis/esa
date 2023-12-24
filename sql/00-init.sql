CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


create table dish
(
    unique_id              bigserial    constraint dish_pkey primary key,
    uuid                   uuid                     default uuid_generate_v4()    not null,
    created_timestamp      timestamp with time zone default statement_timestamp() not null,
    modified_timestamp     timestamp with time zone default statement_timestamp() not null,
    is_deleted             boolean                  default false                 not null,

    name                   varchar                                                not null,
    portion                double precision         default 1.,
    recipe                 varchar                  default '',
    time_min               varchar,
    time_max               varchar
);

comment on table dish is 'Таблица, содержащая данные о блюде';
comment on column dish.unique_id is 'Идентификатор записи. Первичный ключ';
comment on column dish.uuid is 'UUID записи';
comment on column dish.created_timestamp is 'Дата и время создания записи';
comment on column dish.modified_timestamp is 'Дата и время последнего изменения записи';
comment on column dish.is_deleted is 'Признак удалённой записи';

comment on column dish.name is 'Наименование';
comment on column dish.portion is 'Количество проций';
comment on column dish.recipe is 'Рецепт';
comment on column dish.time_min is 'Минимальное время на приготовление';
comment on column dish.time_max is 'Максимальное время на приготовление';


create table ingredient
(
    unique_id              bigserial    constraint ingredient_pkey primary key,
    uuid                   uuid                     default uuid_generate_v4()    not null,
    created_timestamp      timestamp with time zone default statement_timestamp() not null,
    modified_timestamp     timestamp with time zone default statement_timestamp() not null,
    is_deleted             boolean                  default false                 not null,

    name                   varchar                                                not null

);

comment on table ingredient is 'Таблица, содержащая данные о ингредиентах';
comment on column ingredient.unique_id is 'Идентификатор записи. Первичный ключ';
comment on column ingredient.uuid is 'UUID записи';
comment on column ingredient.created_timestamp is 'Дата и время создания записи';
comment on column ingredient.modified_timestamp is 'Дата и время последнего изменения записи';
comment on column ingredient.is_deleted is 'Признак удалённой записи';

comment on column ingredient.name is 'Наименование';


create table dict_unit
(
    unique_id              bigserial constraint dict_unit_pkey primary key,
    uuid                   uuid                     default uuid_generate_v4()    not null,
    created_timestamp      timestamp with time zone default statement_timestamp() not null,
    modified_timestamp     timestamp with time zone default statement_timestamp() not null,
    is_deleted             boolean                  default false                 not null,

    name               varchar                                                    not null,
    code               bigint                                                     not null
        constraint dict_unit_code_key unique,
    description        varchar
);

comment on table dict_unit is 'Таблица, содержащая единицы измерения ингридиентов';
comment on column dict_unit.unique_id is 'Идентификатор записи. Первичный ключ';
comment on column dict_unit.uuid is 'uuid объекта';
comment on column dict_unit.created_timestamp is 'Дата и время создания записи';
comment on column dict_unit.modified_timestamp is 'Дата и время последнего изменения записи';
comment on column dict_unit.is_deleted is 'Признак удалённой записи';

comment on column dict_unit.name is 'Наименование';
comment on column dict_unit.code is 'Код записи';
comment on column dict_unit.description is 'Описание';


create table link_dish_ingredient
(
    unique_id              bigserial    constraint link_dish_ingredient_pkey primary key,
    dish_ref               bigint not null constraint link_dish_ingredient_dish_ref_fkey
        references dish
        on update restrict on delete restrict,
    ingredient_ref          bigint not null constraint link_dish_ingredient_ingredient_ref_fkey
        references ingredient
        on update restrict on delete restrict,
    volume                 double precision,
    unit                   bigint
            constraint link_dish_ingredient_unit_fkey
                references dict_unit (code)
                on update restrict on delete restrict
);

comment on table link_dish_ingredient is 'Таблица связи блюдо-ингредиент';
comment on column link_dish_ingredient.unique_id is 'Идентификатор записи. Первичный ключ';

comment on column link_dish_ingredient.dish_ref  is 'Ссылка на блюдо';
comment on column link_dish_ingredient.ingredient_ref is 'Ссылка на ингредиент';
comment on column link_dish_ingredient.volume  is 'Количество ингредиента (в ед. измерения)';
comment on column link_dish_ingredient.unit is 'Единица измерения';


create table log_event
(
    unique_id              bigserial constraint log_event_pkey primary key,
    uuid                   uuid                     default uuid_generate_v4()    not null,
    created_timestamp      timestamp with time zone default statement_timestamp() not null,
    modified_timestamp     timestamp with time zone default statement_timestamp() not null,
    is_deleted             boolean                  default false                 not null,

    event_type               varchar                                              not null,
    table_name               varchar                                              not null,
    description              varchar
);

comment on table log_event is 'Таблица, содержащая логи изменений данных таблиц';
comment on column log_event.unique_id is 'Идентификатор записи. Первичный ключ';
comment on column log_event.uuid is 'uuid объекта';
comment on column log_event.created_timestamp is 'Дата и время создания записи';
comment on column log_event.modified_timestamp is 'Дата и время последнего изменения записи';
comment on column log_event.is_deleted is 'Признак удалённой записи';

comment on column log_event.event_type is 'Тип изменения';
comment on column log_event.table_name is 'Таблица, в которой произошли изменения';
comment on column log_event.description is 'Доп. информация';


create table mail_condition
(
    unique_id              bigserial constraint mail_condition_pkey primary key,
    uuid                   uuid                     default uuid_generate_v4()    not null,
    created_timestamp      timestamp with time zone default statement_timestamp() not null,
    modified_timestamp     timestamp with time zone default statement_timestamp() not null,
    is_deleted             boolean                  default false                 not null,

    address               varchar                                                 not null,
    condition             varchar                                                 not null
);

comment on table mail_condition is 'Таблица, содержащая единицы измерения ингридиентов';
comment on column mail_condition.unique_id is 'Идентификатор записи. Первичный ключ';
comment on column mail_condition.uuid is 'uuid объекта';
comment on column mail_condition.created_timestamp is 'Дата и время создания записи';
comment on column mail_condition.modified_timestamp is 'Дата и время последнего изменения записи';
comment on column mail_condition.is_deleted is 'Признак удалённой записи';

comment on column mail_condition.address is 'Email';
comment on column mail_condition.condition is 'Условие для отправки письма';