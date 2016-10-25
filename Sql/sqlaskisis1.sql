select name
from sakila.language
order by  name 




select first_name,last_name
from sakila.actor
where first_name  like '%son%'
order by first_name


select address
from sakila.address
where district = ''
order by city_id asc



/* select  category.name, title
from sakila.film, sakila.film_category,sakila.category
where film.film_id=film_category.film_id and category.category_id=film_category.category_id
order by title  */

/* enas allos tropos */


 
select  film.title,category.name
from film
inner join film_category
on film.film_id=film_category.film_id
inner join category
on film_category.category_id=category.category_id
order by film.title


select film_category.category_id,count(film.film_id)
from film
inner join film_category
on film.film_id= film_category.film_id
group by film_category.category_id
order by count(film.film_id);



select film_category.category_id,count(film.film_id)
from film
inner join film_category
on film.film_id= film_category.film_id
group by film_category.category_id
order by count(film.film_id);


select film_category.category_id,avg(film.replacement_cost - film.rental_rate)
from film_category
inner join film
on film.film_id=film_category.category_id 
group by film_category.category_id
having avg(film.replacement_cost - film.rental_rate)>17


select category.name,avg(film.replacement_cost - film.rental_rate)
from film_category
inner join film
on film.film_id=film_category.category_id 
inner join category
on category.category_id=film_category.category_id
group by film_category.category_id
having avg(film.replacement_cost - film.rental_rate)>17



select actor.actor_id, actor.first_name,actor.last_name, count( film_actor.film_id) as a
from actor
inner join film_actor
on actor.actor_id=film_actor.actor_id
group by actor.actor_id
order by a


select actor.actor_id, actor.first_name,actor.last_name, count( film_actor.film_id) 
from actor
inner join film_actor
on actor.actor_id=film_actor.actor_id
inner join film
on film.film_id=film_actor.film_id
where film.length>183
group by actor.actor_id

select film.title
from film
inner join language
on language.language_id=film.language_id
inner join film_category
on film_category.film_id=film.film_id
inner join category
on film_category.category_id=category.category_id
where  language.name='English' and category.name='Documentary'


select film.film_id,film.title
from film
where film.film_id not in( select inventory.film_id from inventory)
