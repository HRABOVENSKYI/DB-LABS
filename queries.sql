-- 1. БД «Кораблі». Вивести назви класів кораблів із водотоннажністю не
-- меншою, аніж 40 тонн. Вивести: class, displacement. Вихідні дані
-- впорядкувати за зростанням за стовпцем type.
select class, displacement
from Classes
where displacement > 40000
order by `type` asc;


-- 2. БД «Аеропорт». З таблиці Trip вивести інформацію про рейси, що
-- прилітають в інтервалі часу між 17 та 23 годинами включно.
select *
from Trip
where time_in between '1900-01-01 17:00:00.00' and '1900-01-01 23:00:00.000';


-- 3. БД «Аеропорт». Для рейсових літаків 'Boeing' вказати назви ком-
-- паній, яким вони належать.
select distinct(Trip.ID_comp), Trip.`plane`, Company.`name`
from Trip
left join Company
on Trip.ID_comp = Company.ID_comp
where Trip.plane = 'Boeing';


-- 4. БД «Комп. фірма». Знайдіть виробників, що випускають ПК, але не
-- ноутбуки (використати ключове слово SOME). Вивести maker.
select distinct(maker)
from Product
where 
	maker = some(select maker from Product where `type` = 'PC') and 
    maker != all(select maker from Product where `type` = 'Laptop');


-- 5. БД «Комп. фірма». Знайдіть виробників, які б випускали ПК зі
-- швидкістю 750 МГц та вище. Виведіть: maker.
select distinct(maker)
from Product
join PC
on Product.model = PC.model
where `type` = 'PC' and speed >= 750;


-- 6. БД «Кораблі». З таблиці Battles виведіть дати в такому форматі:
-- рік.число_місяця.день, наприклад, 2001.02.21 (без формату часу).
SELECT date_format(convert(`date`, date), '%Y.%m.%d')
from Battles;


-- 7. БД «Комп. фірма». Знайдіть середній розмір жорсткого диску ПК
-- (одне значення на всіх) тих виробників, які також випускають і
-- принтери. Вивести: середній розмір жорсткого диску.
select avg(hd)
from Product
join PC
on Product.model = PC.model
where
	type='PC' and 
    maker = some(select maker from Product where `type` = 'PC') and 
    maker = some(select maker from Product where `type` = 'Printer');


-- 8. БД «Комп. фірма». Для кожного значення швидкості ПК, що
-- перевищує 600 МГц, визначіть середню ціну ПК із такою ж
-- швидкістю. Вивести: speed, середня ціна. (Підказка: використовувати
-- підзапити в якості обчислювальних стовпців)
select speed, avg(price)
from PC
where speed > 600
group by speed;


-- 9. БД «Кораблі». Визначити назви всіх кораблів із таблиці Ships, які
-- задовольняють, у крайньому випадку, комбінації будь-яких чотирьох
-- критеріїв із наступного списку: numGuns=12, bore=16,
-- displacement=46000, type='bc', country='Gt.Britain', launched=1941,
-- class='North Carolina'. Вивести: name, numGuns, bore, displacement,
-- type, country, launched, class. (Підказка: використати для перевірки
-- умов оператор CASE)
SELECT *
FROM 
	(SELECT `name`, numGuns, bore, displacement, type,
		country, 
        launched, 
        classes.class, 
        (numGuns=12) + (bore=16) + (displacement=46000) + (type='bc') + (country='Gt.Britain') + 
        (launched=1941) + (classes.class='North Carolina') AS n
	FROM ships JOIN classes ON ships.class  = classes.class) T    
WHERE n >= 4;



-- 10. БД «Кораблі». Перерахуйте назви головних кораблів, що є наяв-
-- ними в БД (врахувати також і кораблі з таблиці Outcomes). Вивести:
-- назва корабля, class. (Підказка: використовувати оператор UNION та
-- операцію EXISTS)
select `name`, class
from
	(select `name`, class, ROW_NUMBER() OVER (PARTITION BY `name`) AS RowNumber
		from
			(select `name`, class
			from Ships
			union
			select ship, null
			from Outcomes) T1) T2      
 where T2.RowNumber = 1;