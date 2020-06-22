package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMembers is a Querydsl query type for Members
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMembers extends EntityPathBase<Members> {

    private static final long serialVersionUID = 574344021L;

    public static final QMembers members = new QMembers("members");

    public final ListPath<Authority, QAuthority> authorities = this.<Authority, QAuthority>createList("authorities", Authority.class, QAuthority.class, PathInits.DIRECT2);

    public final NumberPath<Long> kakaoId = createNumber("kakaoId", Long.class);

    public final StringPath memberEmail = createString("memberEmail");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final DateTimePath<java.sql.Timestamp> memberJoinDate = createDateTime("memberJoinDate", java.sql.Timestamp.class);

    public final StringPath memberPassword = createString("memberPassword");

    public final NumberPath<Integer> memberStatus = createNumber("memberStatus", Integer.class);

    public QMembers(String variable) {
        super(Members.class, forVariable(variable));
    }

    public QMembers(Path<? extends Members> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMembers(PathMetadata metadata) {
        super(Members.class, metadata);
    }

}

