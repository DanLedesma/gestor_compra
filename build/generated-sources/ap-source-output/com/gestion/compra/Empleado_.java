package com.gestion.compra;

import com.gestion.compra.Departamento;
import com.gestion.compra.SolEncArticulo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-11T20:03:32")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> estado;
    public static volatile CollectionAttribute<Empleado, SolEncArticulo> solEncArticuloCollection;
    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile SingularAttribute<Empleado, String> cedula;
    public static volatile SingularAttribute<Empleado, Departamento> departamento;
    public static volatile SingularAttribute<Empleado, String> nombre;

}