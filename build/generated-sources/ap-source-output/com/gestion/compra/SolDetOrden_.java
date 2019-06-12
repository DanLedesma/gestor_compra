package com.gestion.compra;

import com.gestion.compra.Articulo;
import com.gestion.compra.Marca;
import com.gestion.compra.SolDetOrdenPK;
import com.gestion.compra.SolEncOrden;
import com.gestion.compra.UnidadMedida;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-11T20:03:33")
@StaticMetamodel(SolDetOrden.class)
public class SolDetOrden_ { 

    public static volatile SingularAttribute<SolDetOrden, SolEncOrden> solEncOrden;
    public static volatile SingularAttribute<SolDetOrden, Marca> marca;
    public static volatile SingularAttribute<SolDetOrden, BigDecimal> costoUni;
    public static volatile SingularAttribute<SolDetOrden, UnidadMedida> unidadMed;
    public static volatile SingularAttribute<SolDetOrden, Integer> cantidad;
    public static volatile SingularAttribute<SolDetOrden, Articulo> articulo1;
    public static volatile SingularAttribute<SolDetOrden, SolDetOrdenPK> solDetOrdenPK;

}