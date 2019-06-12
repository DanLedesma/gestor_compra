package com.gestion.compra;

import com.gestion.compra.Empleado;
import com.gestion.compra.Proveedor;
import com.gestion.compra.SolDetArticulo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-11T20:03:33")
@StaticMetamodel(SolEncArticulo.class)
public class SolEncArticulo_ { 

    public static volatile SingularAttribute<SolEncArticulo, Proveedor> idProv;
    public static volatile SingularAttribute<SolEncArticulo, String> estado;
    public static volatile CollectionAttribute<SolEncArticulo, SolDetArticulo> solDetArticuloCollection;
    public static volatile SingularAttribute<SolEncArticulo, Empleado> empSol;
    public static volatile SingularAttribute<SolEncArticulo, Date> fecSol;
    public static volatile SingularAttribute<SolEncArticulo, Integer> idSolicitud;

}