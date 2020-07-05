package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecruitAddr is a Querydsl query type for RecruitAddr
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRecruitAddr extends EntityPathBase<RecruitAddr> {

    private static final long serialVersionUID = -1726002037L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecruitAddr recruitAddr = new QRecruitAddr("recruitAddr");

    public final QCompanyAddr companyAddr;

    public final NumberPath<Long> recruitAddrId = createNumber("recruitAddrId", Long.class);

    public final QRecruitForm recruitForm;

    public QRecruitAddr(String variable) {
        this(RecruitAddr.class, forVariable(variable), INITS);
    }

    public QRecruitAddr(Path<? extends RecruitAddr> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecruitAddr(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecruitAddr(PathMetadata metadata, PathInits inits) {
        this(RecruitAddr.class, metadata, inits);
    }

    public QRecruitAddr(Class<? extends RecruitAddr> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.companyAddr = inits.isInitialized("companyAddr") ? new QCompanyAddr(forProperty("companyAddr"), inits.get("companyAddr")) : null;
        this.recruitForm = inits.isInitialized("recruitForm") ? new QRecruitForm(forProperty("recruitForm"), inits.get("recruitForm")) : null;
    }

}

