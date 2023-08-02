package yk.web.myyk.util.comparator;

import java.util.Comparator;

import yk.web.myyk.backend.entity.BaseEntityWithTime;

public class MyComparator {

	/**
	 * <p>엔티티의 등록일자가 오래된 순으로 정렬한다.</p>
	 * 
	 * @return 컴퍼레이터
	 */
	public static Comparator<BaseEntityWithTime> getRegisterAsc() {
		return new Comparator<BaseEntityWithTime>() {
			@Override
			public int compare(BaseEntityWithTime o1, BaseEntityWithTime o2) {
				
				if(o1.getRegisterdDate().isAfter(o2.getRegisterdDate())) {
					return 1;
				} else if (o1.getRegisterdDate().isBefore(o2.getRegisterdDate())) {
					return -1;
				}
				return 0;
			}
		};
	}
	
	/**
	 * <p>엔티티의 등록일자가 최신 순으로 정렬한다.</p>
	 * 
	 * @return 컴퍼레이터
	 */
	public static Comparator<BaseEntityWithTime> getRegisterDesc() {
		return new Comparator<BaseEntityWithTime>() {
			@Override
			public int compare(BaseEntityWithTime o1, BaseEntityWithTime o2) {
				
				if(o1.getRegisterdDate().isBefore(o2.getRegisterdDate())) {
					return 1;
				} else if (o1.getRegisterdDate().isAfter(o2.getRegisterdDate())) {
					return -1;
				}
				return 0;
			}
		};
	}
	
	/**
	 * <p>엔티티의 수정일자가 오래된 순으로 정렬한다.</p>
	 * 
	 * @return 컴퍼레이터
	 */
	public static Comparator<BaseEntityWithTime> getModifyAsc() {
		return new Comparator<BaseEntityWithTime>() {
			@Override
			public int compare(BaseEntityWithTime o1, BaseEntityWithTime o2) {
				
				if(o1.getModifiedDate().isAfter(o2.getModifiedDate())) {
					return 1;
				} else if (o1.getModifiedDate().isBefore(o2.getModifiedDate())) {
					return -1;
				}
				return 0;
			}
		};
	}
	
	/**
	 * <p>엔티티의 수정일자가 최신 순으로 정렬한다.</p>
	 * 
	 * @return 컴퍼레이터
	 */
	public static Comparator<BaseEntityWithTime> getModifyDesc() {
		return new Comparator<BaseEntityWithTime>() {
			@Override
			public int compare(BaseEntityWithTime o1, BaseEntityWithTime o2) {
				
				if(o1.getModifiedDate().isBefore(o2.getModifiedDate())) {
					return 1;
				} else if (o1.getModifiedDate().isAfter(o2.getModifiedDate())) {
					return -1;
				}
				return 0;
			}
		};
	}
	
	
	
}
