package com.gestion.compra;

import com.gestion.compra.SolDetOrden;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-11T20:03:33")
@StaticMetamodel(Marca.class)
public class Marca_ { 

    public static volatile SingularAttribute<Marca, String> descripcion;
    public static volatile SingularAttribute<Marca, String> estado;
    public static volatile SingularAttribute<Marca, Integer> idMarca;
    public static volatile CollectionAttribute<Marca, SolDetOrden> solDetOrdenCollection;

}