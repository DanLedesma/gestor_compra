package com.gestion.compra;

import com.gestion.compra.SolEncArticulo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-11T20:03:33")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> estado;
    public static volatile CollectionAttribute<Proveedor, SolEncArticulo> solEncArticuloCollection;
    public static volatile SingularAttribute<Proveedor, Integer> idProveedor;
    public static volatile SingularAttribute<Proveedor, String> nombreCom;
    public static volatile SingularAttribute<Proveedor, String> cedulaRnc;

}