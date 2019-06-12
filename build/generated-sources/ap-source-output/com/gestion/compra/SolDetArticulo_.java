package com.gestion.compra;

import com.gestion.compra.Articulo;
import com.gestion.compra.SolDetArticuloPK;
import com.gestion.compra.SolEncArticulo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-11T20:03:33")
@StaticMetamodel(SolDetArticulo.class)
public class SolDetArticulo_ { 

    public static volatile SingularAttribute<SolDetArticulo, SolDetArticuloPK> solDetArticuloPK;
    public static volatile SingularAttribute<SolDetArticulo, Integer> unidadMed;
    public static volatile SingularAttribute<SolDetArticulo, Integer> cantidad;
    public static volatile SingularAttribute<SolDetArticulo, Articulo> articulo1;
    public static volatile SingularAttribute<SolDetArticulo, SolEncArticulo> solEncArticulo;

}