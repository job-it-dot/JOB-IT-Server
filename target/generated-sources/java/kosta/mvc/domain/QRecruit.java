package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecruit is a Querydsl query type for Recruit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRecruit extends EntityPathBase<Recruit> {

    private static final long serialVersionUID = 708151674L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecruit recruit = new QRecruit("recruit");

    public final ListPath<Apply, QApply> applys = this.<Apply, QApply>createList("applys", Apply.class, QApply.class, PathInits.DIRECT2);

    public final QCompanys company;

    public final QPositions position;

    public final QRecruitAddr recruitAddr;

    public final NumberPath<Integer> recruitCareer = createNumber("recruitCareer", Integer.class);

    public final StringPath recruitDetail = createString("recruitDetail");

    public final DateTimePath<java.util.Date> recruitEndDate = createDateTime("recruitEndDate", java.util.Date.class);

    public final NumberPath<Long> recruitId = createNumber("recruitId", Long.class);

    public final NumberPath<Integer> recruitSalary = createNumber("recruitSalary", Integer.class);

    public final NumberPath<Integer> recruitStatus = createNumber("recruitStatus", Integer.class);

    public final QRequiredEdu requiredEdu;

    public final ListPath<RequiredSkill, QRequiredSkill> requiredSkills = this.<RequiredSkill, QRequiredSkill>createList("requiredSkills", RequiredSkill.class, QRequiredSkill.class, PathInits.DIRECT2);

    public QRecruit(String variable) {
        this(Recruit.class, forVariable(variable), INITS);
    }

    public QRecruit(Path<? extends Recruit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecruit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecruit(PathMetadata metadata, PathInits inits) {
        this(Recruit.class, metadata, inits);
    }

    public QRecruit(Class<? extends Recruit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompanys(forProperty("company"), inits.get("company")) : null;
        this.position = inits.isInitialized("position") ? new QPositions(forProperty("position")) : null;
        this.recruitAddr = inits.isInitialized("recruitAddr") ? new QRecruitAddr(forProperty("recruitAddr"), inits.get("recruitAddr")) : null;
        this.requiredEdu = inits.isInitialized("requiredEdu") ? new QRequiredEdu(forProperty("requiredEdu")) : null;
    }

}

