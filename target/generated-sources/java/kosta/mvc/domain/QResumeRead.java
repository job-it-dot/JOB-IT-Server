package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResumeRead is a Querydsl query type for ResumeRead
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResumeRead extends EntityPathBase<ResumeRead> {

    private static final long serialVersionUID = -83772505L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResumeRead resumeRead = new QResumeRead("resumeRead");

    public final QCompanys company;

    public final BooleanPath isNew = createBoolean("isNew");

    public final QResume resume;

    public final NumberPath<Long> resumeReadId = createNumber("resumeReadId", Long.class);

    public final QUsers user;

    public QResumeRead(String variable) {
        this(ResumeRead.class, forVariable(variable), INITS);
    }

    public QResumeRead(Path<? extends ResumeRead> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResumeRead(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResumeRead(PathMetadata metadata, PathInits inits) {
        this(ResumeRead.class, metadata, inits);
    }

    public QResumeRead(Class<? extends ResumeRead> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompanys(forProperty("company"), inits.get("company")) : null;
        this.resume = inits.isInitialized("resume") ? new QResume(forProperty("resume"), inits.get("resume")) : null;
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user"), inits.get("user")) : null;
    }

}

