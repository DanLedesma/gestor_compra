package com.gestion.compra;

import com.gestion.compra.SolDetOrden;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-11T20:03:33")
@StaticMetamodel(SolEncOrden.class)
public class SolEncOrden_ { 

    public static volatile SingularAttribute<SolEncOrden, String> estado;
    public static volatile SingularAttribute<SolEncOrden, Integer> idSol;
    public static volatile SingularAttribute<SolEncOrden, Date> fecOrd;
    public static volatile SingularAttribute<SolEncOrden, Integer> idOrden;
    public static volatile CollectionAttribute<SolEncOrden, SolDetOrden> solDetOrdenCollection;

}