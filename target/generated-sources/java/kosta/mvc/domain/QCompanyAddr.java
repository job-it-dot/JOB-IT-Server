package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompanyAddr is a Querydsl query type for CompanyAddr
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompanyAddr extends EntityPathBase<CompanyAddr> {

    private static final long serialVersionUID = 1280526922L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompanyAddr companyAddr = new QCompanyAddr("companyAddr");

    public final QCompanys company;

    public final NumberPath<Double> companyAddrCoordX = createNumber("companyAddrCoordX", Double.class);

    public final NumberPath<Double> companyAddrCoordY = createNumber("companyAddrCoordY", Double.class);

    public final StringPath companyAddrDetail = createString("companyAddrDetail");

    public final NumberPath<Long> companyAddrId = createNumber("companyAddrId", Long.class);

    public final StringPath companyAddrName = createString("companyAddrName");

    public QCompanyAddr(String variable) {
        this(CompanyAddr.class, forVariable(variable), INITS);
    }

    public QCompanyAddr(Path<? extends CompanyAddr> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompanyAddr(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompanyAddr(PathMetadata metadata, PathInits inits) {
        this(CompanyAddr.class, metadata, inits);
    }

    public QCompanyAddr(Class<? extends CompanyAddr> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompanys(forProperty("company"), inits.get("company")) : null;
    }

}

