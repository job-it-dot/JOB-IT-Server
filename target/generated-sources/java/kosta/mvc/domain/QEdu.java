package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEdu is a Querydsl query type for Edu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEdu extends EntityPathBase<Edu> {

    private static final long serialVersionUID = 35719154L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEdu edu = new QEdu("edu");

    public final StringPath eduDetail = createString("eduDetail");

    public final StringPath eduGraduateAt = createString("eduGraduateAt");

    public final NumberPath<Long> eduId = createNumber("eduId", Long.class);

    public final StringPath eduJoinAt = createString("eduJoinAt");

    public final StringPath eduName = createString("eduName");

    public final NumberPath<Integer> eduStatus = createNumber("eduStatus", Integer.class);

    public final QResume resume;

    public QEdu(String variable) {
        this(Edu.class, forVariable(variable), INITS);
    }

    public QEdu(Path<? extends Edu> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEdu(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEdu(PathMetadata metadata, PathInits inits) {
        this(Edu.class, metadata, inits);
    }

    public QEdu(Class<? extends Edu> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.resume = inits.isInitialized("resume") ? new QResume(forProperty("resume"), inits.get("resume")) : null;
    }

}

