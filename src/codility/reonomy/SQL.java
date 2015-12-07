package codility.reonomy;

public class SQL {

	public static void main(String[] args) {

		/**
		 * Events table
		 * 
		 * event_type	value	time
		 * 2			2		today_afternoon
		 * 2			7		today_morning
		 * 3			8		yesterday_night
		 * 5			9		yesterday_morning
		 * 3			4		today_morning
		 * 2			8		yesterday_night
		 * 
create table events(
event_type Number,
event_value Number,
event_time date
);

insert into events values(2,2,TO_DATE('2015-11-17 14:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into events values(2,7,TO_DATE('2015-11-17 10:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into events values(3,8,TO_DATE('2015-11-16 20:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into events values(5,9,TO_DATE('2015-11-16 09:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into events values(3,4,TO_DATE('2015-11-17 08:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into events values(2,8,TO_DATE('2015-11-16 19:00:00','YYYY-MM-DD HH24:MI:SS'));
commit;
		 * 
		 * output-
		 * event_type	value
		 * 2			-5			
		 * 3			-4
		 * 
EVENT_TYPE	EVENT_VALUE		DIFF_VALUE
2			2				-5
3			4				-4
		 * 
		 * Show records where event type occuring more than once and show the difference between 2 latest records
		 * ordered by time
		 * 
		 */
		/*
		 * select max_table.event_type, max, min, max-min as value from (select
		 * event_type, max(value) max from events group by event_type having
		 * count(event_type) > 1 order by time) max_table join (select
		 * event_type, min(value) min from events group by event_type having
		 * count(event_type) > 1 order by time) min_table on
		 * max_table.event_type=min_table.event_type order by
		 * max_table.event_type
		 */
	
		/**
		 * ANSWER
WITH FILTERED AS
(
select event_type, event_value, event_time,
event_value - lead(event_value,1,0) over 
(partition by event_type order by event_time desc) as diff_value ,
ROW_NUMBER() OVER (partition by event_type order by event_time desc) AS rn,
  COUNT(event_type) OVER ( PARTITION BY event_type) cnt 
 from  events order by event_type, event_time desc
)
select event_type, event_value,  diff_value from FILTERED where rn = 1 
and cnt > 1;
		 */
	
	}
}
