insert into dish (name, portion, recipe, time_min, time_max)
values ('макароны', 1., 'Залить воды в кастрюлю, сыпнуть соли и варить', '5m', '15m'),
       ('сыр жаренный',  1.5, 'Порезать и пожарить)))', '10m', '20m');

insert into ingredient (name)
values ('сыр для жарки'),
       ('макароны');

insert into link_dish_ingredient (dish_ref, ingredient_ref, volume, unit)
values (1, 2, null, null),
       (2, 1, 1., 9);

