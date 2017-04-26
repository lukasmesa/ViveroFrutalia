CREATE FUNCTION insertarEmpleados() returns void AS $$
begin
	for i in 1..10 loop
	insert into empleados
	values ('cedulaEmp'||i,'nombreEmp'|| i, 'apellEmp'|| i, '888888'|| i,'correoEmp'|| i||'@frutalia.com','HojaDeVidaEmp'|| i||'.docx');
	end loop;
end;
$$
CREATE FUNCTION insertarClientes() returns void AS $$
begin
	for i in 1..100 loop
	insert into clientes
	values ('cedulaEmp'||i,'nombreCl'|| i, 'apellCl'|| i, '888888'|| i,'correoCl'|| i||'@gmail.com');
	end loop;
end;
$$
CREATE FUNCTION insertarProveedores() returns void AS $$
begin
	for i in 1..20 loop
	insert into proveedores
	values ('cedulaProv'||i,'nombreProv'|| i, 'apellProv'|| i, '888888'|| i,'correoProv'|| i||'@gmail.com');
	end loop;
end;
$$

insert into tipoPlanta (nombre, descripcion)
	values ('Ornamental','Descripcion de ornamental');
insert into tipoPlanta (nombre, descripcion)
	values ('Frutal','Descripcion de frutal');
insert into tipoPlanta (nombre, descripcion)
	values ('Medicinal','descripcion de medicinal');	
insert into tipoPlanta (nombre, descripcion)
	values ('Forestal','descripcion de forestales');
insert into tipoPlanta (nombre, descripcion)
	values ('Acuatica','descripcion de Acuaticas');	

	
LANGUAGE plpgsql;





