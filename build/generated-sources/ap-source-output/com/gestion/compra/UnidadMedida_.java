package com.gestion.compra;

import com.gestion.compra.SolDetOrden;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-11T20:03:33")
@StaticMetamodel(UnidadMedida.class)
public class UnidadMedida_ { 

    public static volatile SingularAttribute<UnidadMedida, String> descripcion;
    public static volatile SingularAttribute<UnidadMedida, String> estado;
    public static volatile SingularAttribute<UnidadMedida, Integer> idUnidades;
    public static volatile CollectionAttribute<UnidadMedida, SolDetOrden> solDetOrdenCollection;

}