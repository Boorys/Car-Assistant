

delete from car_user_to_information_entity
insert into car_user_to_information_entity(break_pads,oil,timing_gear,email,car_model,first_name) 
select 
case when (cue.kilometers_since_the_last_change_braek_pads>=cme.brake_pads) then 1 else 0 
end,
case when (cue.kilometers_since_the_last_change_oil>=cme.oil) then 1 else 0 
end,
case when (cue.kilometers_since_the_last_change_timing_gear>=cme.timing_gear) then 1 else 0 
end
,user_entity.email,cme.model,user_entity.first_name


from
 car_user_entity cue join user_entity  on cue.users=user_entity .id
 join car_model_entity cme on cme.id=cue.car_model 


where ((cue.kilometers_since_the_last_change_braek_pads>=cme.brake_pads) or (cue.kilometers_since_the_last_change_oil>=cme.oil)or(cue.kilometers_since_the_last_change_timing_gear>=cme.timing_gear))


update car_user_entity
set kilometers_since_the_last_change_oil=0
from 
car_user_entity cue join car_model_entity cme on cme.id=cue.car_model 
where(cue.kilometers_since_the_last_change_oil>=cme.oil)


update car_user_entity
set kilometers_since_the_last_change_braek_pads=0
from 
car_user_entity cue join car_model_entity cme on cme.id=cue.car_model 
where(cue.kilometers_since_the_last_change_braek_pads>=cme.brake_pads)


update car_user_entity
set kilometers_since_the_last_change_timing_gear=0
from 
car_user_entity cue join car_model_entity cme on cme.id=cue.car_model 
where(cue.kilometers_since_the_last_change_timing_gear>=cme.timing_gear)
