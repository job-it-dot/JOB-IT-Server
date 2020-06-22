package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLang is a Querydsl query type for Lang
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLang extends EntityPathBase<Lang> {

    private static final long serialVersionUID = 1107499314L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLang lang = new QLang("lang");

    public final QLangClass langClass;

    public final NumberPath<Long> langId = createNumber("langId", Long.class);

    public final QLangLevel langLevel;

    public final ListPath<LangLicense, QLangLicense> langLicenses = this.<LangLicense, QLangLicense>createList("langLicenses", LangLicense.class, QLangLicense.class, PathInits.DIRECT2);

    public final QResume resume;

    public QLang(String variable) {
        this(Lang.class, forVariable(variable), INITS);
    }

    public QLang(Path<? extends Lang> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLang(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLang(PathMetadata metadata, PathInits inits) {
        this(Lang.class, metadata, inits);
    }

    public QLang(Class<? extends Lang> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.langClass = inits.isInitialized("langClass") ? new QLangClass(forProperty("langClass")) : null;
        this.langLevel = inits.isInitialized("langLevel") ? new QLangLevel(forProperty("langLevel")) : null;
        this.resume = inits.isInitialized("resume") ? new QResume(forProperty("resume"), inits.get("resume")) : null;
    }

}

