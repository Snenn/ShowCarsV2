SELECT * FROM Ad where price >= :minPriceQuery and price <= :maxPriceQuery
                            and year >= :minYearQuery and year <= :maxYearQuery and make = :make and model = :model
order by id desc