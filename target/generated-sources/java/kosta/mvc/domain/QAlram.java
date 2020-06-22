package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlram is a Querydsl query type for Alram
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlram extends EntityPathBase<Alram> {

    private static final long serialVersionUID = -37086897L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlram alram = new QAlram("alram");

    public final NumberPath<Long> alramId = createNumber("alramId", Long.class);

    public final BooleanPath isNew = createBoolean("isNew");

    public final QRecruit recruit;

    public final QUsers user;

    public QAlram(String variable) {
        this(Alram.class, forVariable(variable), INITS);
    }

    public QAlram(Path<? extends Alram> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlram(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlram(PathMetadata metadata, PathInits inits) {
        this(Alram.class, metadata, inits);
    }

    public QAlram(Class<? extends Alram> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.recruit = inits.isInitialized("recruit") ? new QRecruit(forProperty("recruit"), inits.get("recruit")) : null;
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user"), inits.get("user")) : null;
    }

}

