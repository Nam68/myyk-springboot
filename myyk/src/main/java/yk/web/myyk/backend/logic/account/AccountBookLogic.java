package yk.web.myyk.backend.logic.account;

import org.springframework.stereotype.Service;

import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.AccountBookService;

@Service
public class AccountBookLogic extends BaseLogic implements AccountBookService {
    
    

//	@Override
//	@Transactional
//	public List<AccountBookDTO> getAuthList(long memberIdx) throws SystemException {
//		
//		List<AccountBookAuthEntity> list = 
//				getRepository().getAccountBookAuth().findAllByMemberMemberIdx(
//						memberIdx, AccountBookAuthRepository.getSort());
//		
//		List<AccountBookDTO> result = new ArrayList<>();
//		for (AccountBookAuthEntity auth : list) {
//			AccountBookEntity entity = auth.getAccountBook();
//			result.add(new AccountBookDTO(entity));
//		}
//		return result;
//	}
//	
//	@Override
//	public AccountBookDTO getAccountBook(@Nullable Long accountBookIdx) throws SystemException {
//		
//		if (accountBookIdx == null || accountBookIdx <= 0) {
////			List<AccountBookAuthEntity> auths = getRepository().getAccountBookAuth().findAllByMemberMemberIdx(
////				getLoginInfo().getMemberIdx(), AccountBookAuthRepository.getSort());
////			if (auths.isEmpty()) {
////				return null;
////			} else {
////				return new AccountBookDTO(auths.get(0).getAccountBook());
////			}
//		}
//		
//		Optional<AccountBookEntity> entity = getRepository().getAccountBook().findById(accountBookIdx);
//		if (!entity.isPresent()) {
//			return null;
//		}
//		return new AccountBookDTO(entity.get()); 
//	}
//	
//	@Override
//	@Transactional
//	public void createBook(AccountBookDTO dto) throws SystemException {
//		
//		// 일단 재료가 되는 가계부 엔티티를 생성한다.
//		AccountBookEntity book = new AccountBookEntity(dto);
//		getRepository().getAccountBook().save(book);
//		
//		// 로그인한 작성자 본인에게 모든 권한을 추가한다
////		int memberIdx = (int) getLoginInfo().getMemberIdx();
////		dto.getWatchableIdx().add(memberIdx);
////		dto.getWritableIdx().add(memberIdx);
//		
//		Map<Long, AccountBookAuthEntity> authMap = new HashMap<>();
//		
//		// 멤버를 불러와서 권한을 생성한다.
//		for (long idx : dto.getWatchableIdx()) {
//			MemberEntity member = getRepository().getMember().findById(idx).get();
//			
//			AccountBookAuthEntity auth = new AccountBookAuthEntity(member, book);
//			authMap.put(idx, auth);
//		}
//		
//		for (long idx : dto.getWritableIdx()) {
//			AccountBookAuthEntity auth = authMap.get(idx);
//			auth.setWritable(true);
//		}
//		
//		for (Entry<Long, AccountBookAuthEntity> entry : authMap.entrySet()) {
//			getRepository().getAccountBookAuth().save(entry.getValue());
//		}
//	}

}
