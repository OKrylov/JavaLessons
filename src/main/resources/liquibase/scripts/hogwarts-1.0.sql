--  liquibase formatted sql

--  changeset okrylov:1
create index student_name_idx on student (name);

-- changeset okrylov:2
create index faculty_name_color_idx on faculty (name, color);