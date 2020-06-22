package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLangLicense is a Querydsl query type for LangLicense
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLangLicense extends EntityPathBase<LangLicense> {

    private static final long serialVersionUID = -1188911441L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLangLicense langLicense = new QLangLicense("langLicense");

    public final QLang lang;

    public final StringPath langLicenseAt = createString("langLicenseAt");

    public final NumberPath<Long> langLicenseId = createNumber("langLicenseId", Long.class);

    public final StringPath langLicenseLevel = createString("langLicenseLevel");

    public final StringPath langLicenseName = createString("langLicenseName");

    public QLangLicense(String variable) {
        this(LangLicense.class, forVariable(variable), INITS);
    }

    public QLangLicense(Path<? extends LangLicense> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLangLicense(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLangLicense(PathMetadata metadata, PathInits inits) {
        this(LangLicense.class, metadata, inits);
    }

    public QLangLicense(Class<? extends LangLicense> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lang = inits.isInitialized("lang") ? new QLang(forProperty("lang"), inits.get("lang")) : null;
    }

}

