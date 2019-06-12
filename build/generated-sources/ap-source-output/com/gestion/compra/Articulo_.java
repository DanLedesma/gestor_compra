package com.gestion.compra;

import com.gestion.compra.SolDetArticulo;
import com.gestion.compra.SolDetOrden;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-11T20:03:33")
@StaticMetamodel(Articulo.class)
public class Articulo_ { 

    public static volatile SingularAttribute<Articulo, Integer> idArticulo;
    public static volatile SingularAttribute<Articulo, String> descripcion;
    public static volatile SingularAttribute<Articulo, Integer> marca;
    public static volatile SingularAttribute<Articulo, Integer> existencia;
    public static volatile SingularAttribute<Articulo, String> estado;
    public static volatile CollectionAttribute<Articulo, SolDetArticulo> solDetArticuloCollection;
    public static volatile SingularAttribute<Articulo, Integer> unidadMed;
    public static volatile SingularAttribute<Articulo, BigDecimal> costo;
    public static volatile CollectionAttribute<Articulo, SolDetOrden> solDetOrdenCollection;

}