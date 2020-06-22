package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResume is a Querydsl query type for Resume
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResume extends EntityPathBase<Resume> {

    private static final long serialVersionUID = -669413775L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResume resume = new QResume("resume");

    public final ListPath<Career, QCareer> careers = this.<Career, QCareer>createList("careers", Career.class, QCareer.class, PathInits.DIRECT2);

    public final ListPath<Edu, QEdu> edus = this.<Edu, QEdu>createList("edus", Edu.class, QEdu.class, PathInits.DIRECT2);

    public final ListPath<Lang, QLang> langs = this.<Lang, QLang>createList("langs", Lang.class, QLang.class, PathInits.DIRECT2);

    public final ListPath<License, QLicense> licenses = this.<License, QLicense>createList("licenses", License.class, QLicense.class, PathInits.DIRECT2);

    public final ListPath<Link, QLink> links = this.<Link, QLink>createList("links", Link.class, QLink.class, PathInits.DIRECT2);

    public final StringPath resumeContent = createString("resumeContent");

    public final NumberPath<Long> resumeId = createNumber("resumeId", Long.class);

    public final StringPath resumeName = createString("resumeName");

    public final StringPath resumePhone = createString("resumePhone");

    public final NumberPath<Integer> resumeStatus = createNumber("resumeStatus", Integer.class);

    public final QUsers user;

    public final ListPath<UserSkill, QUserSkill> userSkills = this.<UserSkill, QUserSkill>createList("userSkills", UserSkill.class, QUserSkill.class, PathInits.DIRECT2);

    public QResume(String variable) {
        this(Resume.class, forVariable(variable), INITS);
    }

    public QResume(Path<? extends Resume> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResume(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResume(PathMetadata metadata, PathInits inits) {
        this(Resume.class, metadata, inits);
    }

    public QResume(Class<? extends Resume> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user"), inits.get("user")) : null;
    }

}

