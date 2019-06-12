package com.gestion.compra;

import com.gestion.compra.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-11T20:03:32")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> estado;
    public static volatile CollectionAttribute<Departamento, Empleado> empleadoCollection;
    public static volatile SingularAttribute<Departamento, String> nombre;
    public static volatile SingularAttribute<Departamento, Integer> idDepto;

}