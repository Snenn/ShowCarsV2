select * FROM model where model.manufacturer_id = (SELECT id FROM manufacturer order by name LIMIT 1) order by name;